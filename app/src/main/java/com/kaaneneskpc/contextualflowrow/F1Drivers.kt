package com.kaaneneskpc.contextualflowrow

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ContextualFlowRow
import androidx.compose.foundation.layout.ContextualFlowRowOverflow.Companion.expandOrCollapseIndicator
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

const val DEFAULT_MAX_LINES = 2

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
fun F1Drivers() {
    var maxLines by remember { mutableIntStateOf(DEFAULT_MAX_LINES) }
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("F1 Drivers") }
            )
        }
    ) { innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .animateContentSize()
            .padding(all = 8.dp)
        ) {
            ContextualFlowRow(
                modifier = Modifier.fillMaxWidth(),
                itemCount = Driver.entries.size,
                maxLines = maxLines,
                overflow = expandOrCollapseIndicator(
                    expandIndicator = {
                        TextButton(
                            onClick = { maxLines += 1 },
                            colors = ButtonDefaults.textButtonColors(
                                contentColor = MaterialTheme.colorScheme.surfaceVariant,
                                containerColor = MaterialTheme.colorScheme.onSurface
                            )
                        ) {
                            Text(text = "${this@expandOrCollapseIndicator.totalItemCount - this@expandOrCollapseIndicator.shownItemCount} + more")
                        }
                    },
                    collapseIndicator = {
                        TextButton(
                            onClick = {maxLines = DEFAULT_MAX_LINES },
                            colors = ButtonDefaults.textButtonColors(
                                contentColor = MaterialTheme.colorScheme.errorContainer,
                                containerColor = MaterialTheme.colorScheme.error
                            )
                        ) {
                            Icon(modifier = Modifier.size(18.dp), imageVector = Icons.Default.Close, contentDescription = "Close Icon")
                            Text(text = "Hide")
                        }
                    }
                ),
                horizontalArrangement = spacedBy(8.dp),
            ) { index ->
                Button(onClick = {}) {
                    Text(text = Driver.entries[index].name)
                }
            }
        }
    }
}

enum class Driver {
    Vettel,
    Hamilton,
    Ocon,
    Gasly,
    Alonso,
    Stroll,
    Leclerc,
    Sainz,
    Magnussen,
    Hulkenberg,
    Piastri,
    Norris,
    Russell,
    Ricciardo,
    Tsunoda,
    Verstappen,
    Perez
}