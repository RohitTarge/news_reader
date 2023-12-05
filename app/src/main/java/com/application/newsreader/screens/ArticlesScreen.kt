package com.application.newsreader.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.application.newsreader.models.Articles
import com.application.newsreader.viewmodels.ArticlesViewModel

@Composable
fun ArticlesScreen(navHostController: NavHostController, viewModel: ArticlesViewModel) {
    val articles = viewModel.news.collectAsState()
    Column {
        HeaderRow()
        if(articles.value.isNotEmpty())
            ArticleList(articles, viewModel, navHostController)
        else
            LinearLoader()

    }
}

@Composable
fun HeaderRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {

        // Image
        Text(
            text = "Image",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .width(100.dp)  // Adjust the width as needed
                .padding(2.dp)
        )
        // Title
        Text(
            text = "Title",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .weight(1f)  // Adjust the width as needed
                .padding(2.dp)
        )

        // Spacer for some horizontal separation
        Spacer(modifier = Modifier.width(8.dp))

        // Published At
        Text(
            text = "PublishedAt",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .weight(1f)  // Adjust the width as needed
                .padding(2.dp)
        )

        // Spacer for some horizontal separation
        Spacer(modifier = Modifier.width(8.dp))

        // Description
        Text(
            text = "Description",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .weight(1f)  // Adjust the width as needed
                .padding(2.dp)
        )
    }
}

@Composable
fun ArticleList(
    articles: State<List<Articles>>,
    viewModel: ArticlesViewModel,
    navHostController: NavHostController
) {
    LazyColumn {
        items(articles.value) { article ->
            ListItem(
                {
                    Row(
                        modifier = Modifier
                            .clickable {
                                viewModel.article = article
                                navHostController.navigate("details")
                            }
                            .fillMaxWidth()
                            .padding(4.dp)
                    ) {
                        AsyncImage(
                            model = article.urlToImage,
                            contentDescription = null,
                            modifier = Modifier
                                .size(48.dp)
                                .padding(2.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))

                        // Title
                        Text(
                            text = article.title ?: "-",
                            modifier = Modifier
                                .weight(1f)  // Equal weight for each element
                                .padding(2.dp),
                            maxLines = 1
                        )
                        Spacer(modifier = Modifier.width(8.dp))

                        // Published At
                        Text(
                            text = article.publishedAt ?: "-",
                            modifier = Modifier
                                .weight(1f)  // Equal weight for each element
                                .padding(2.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))

                        // Description
                        Text(
                            text = article.description ?: "-",
                            modifier = Modifier
                                .weight(1f)
                                .padding(2.dp),
                            maxLines = 2
                        )
                    }
                }
            )
        }
    }
}

@Composable
fun LinearLoader() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        LinearProgressIndicator(
            modifier = Modifier
                .width(120.dp) // Set the width as needed
                .height(2.dp)  // Set the height as needed
                .background(MaterialTheme.colorScheme.primary)
        )
    }
}
