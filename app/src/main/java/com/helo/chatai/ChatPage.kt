package com.helo.chatai

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ChatPage(viewModel: ChatViewModel, modifier: Modifier = Modifier) {
    Box(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            topBar = { ChatHeader() },
            bottomBar = { ChatInput(onMessageSend = { viewModel.sendMessage(it) }) },
            containerColor = Color.Transparent
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                MessageList(
                    modifier = Modifier.weight(1f),
                    messageList = viewModel.messageList
                )
            }
        }
    }
}


@Composable
fun ChatHeader() {
    Box(
        modifier = Modifier

            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary)
            .padding(20.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "ChatAi", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
    }
}


@Composable
fun ChatBubble(message: MessageModel) {
    val isUser = message.role == "user"
    val gradientColors = if (isUser) {
        listOf(Color(0xFF4285F4), Color(0xFF0F9D58))
    } else {
        listOf(Color(0xFF999795), Color(0xFF4285F4))
    }
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = if (isUser) Arrangement.End else Arrangement.Start
    ) {
        Box(
            modifier = Modifier
                .padding(8.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(
                    brush = Brush.linearGradient(colors = gradientColors)
                )
                .padding(12.dp)
        ) {
            if (isUser) {
                SelectionContainer {
                    Text(text = message.message, color = Color.White, fontSize = 16.sp)
                }
            } else {
                TypewriterText(
                    messageModel = message,
                    textStyle = TextStyle(color = Color.White, fontSize = 16.sp)
                )
            }
        }
    }
}

@Composable
fun TypewriterText(
    messageModel: MessageModel,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = TextStyle.Default,
    delayBetweenCharacters: Int = 50,
) {
    var displayedText by remember { mutableStateOf("") }
    var currentCharacterIndex by remember { mutableStateOf(0) }

    if (messageModel.isAnimationFinished) {
        displayedText = messageModel.message
    } else {
        LaunchedEffect(messageModel.message) {
            displayedText = ""
            currentCharacterIndex = 0
            while (currentCharacterIndex < messageModel.message.length) {
                displayedText += messageModel.message[currentCharacterIndex]
                currentCharacterIndex++
                kotlinx.coroutines.delay(delayBetweenCharacters.toLong())
            }
            messageModel.isAnimationFinished = true
        }
    }
    Text(
        text = displayedText,
        modifier = modifier,
        style = textStyle
    )
}

@Composable
fun MessageList(modifier: Modifier = Modifier,messageList : List<MessageModel>) {
    val warriotFontFamily = FontFamily(
        Font(R.font.warriot1, FontWeight.Normal)
    )
    if(messageList.isEmpty()){

        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier.size(300.dp),
                painter = painterResource(id = R.drawable.ask),
                contentDescription = "Robot",
            )

            Text(text = "Ask me anything",fontFamily = warriotFontFamily, fontSize = 22.sp)
        }
    }else{
        LazyColumn(
            modifier = modifier,
            reverseLayout = true
        ) {
            items(messageList.reversed()){
                ChatBubble(message = it)
            }
        }
    }
}


@Composable
fun ChatInput(onMessageSend: (String) -> Unit) {
    var text by remember { mutableStateOf(TextFieldValue("")) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),

        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
            modifier = Modifier
                .weight(1f)
                .clip(RoundedCornerShape(10.dp)),
            value = text,
            onValueChange = { text = it },
            placeholder = { Text("Type a message...") }
        )
        IconButton(onClick = {
            if (text.text.isNotEmpty()) {
                onMessageSend(text.text)
                text = TextFieldValue("")
            }
        }) {
            Icon(imageVector = Icons.Default.Send, contentDescription = "Send Message")
        }
    }
}
