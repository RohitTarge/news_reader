package com.application.newsreader.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.application.newsreader.viewmodels.ArticlesViewModel

@Composable
fun ArticleDetailScreen(viewModel: ArticlesViewModel) {
    val article = viewModel.article
    if (article != null) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            // News Image
            AsyncImage(
                model = article.urlToImage,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(MaterialTheme.shapes.medium)
            )

            // Spacer for some vertical separation
            Spacer(modifier = Modifier.height(16.dp))

            // News Content
            Text(
                text = article.content ?: "-",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.fillMaxWidth()
            )

            // Spacer for some vertical separation
            Spacer(modifier = Modifier.height(16.dp))

            // Clickable Text for URL
            ClickableText(
                text = AnnotatedString("Read more: ${article.url}"),
                onClick = {
                    // handle url click listener
                }
            )
        }
    }
}