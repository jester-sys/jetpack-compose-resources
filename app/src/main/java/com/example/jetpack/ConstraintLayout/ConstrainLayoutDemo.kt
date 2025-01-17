package com.example.jetpack.ConstraintLayout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.TextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.widget.ConstraintLayout


@Composable
fun ConstraintLayoutDemo() {
    // This function calls different examples of ConstraintLayout usage.
    // Uncomment the respective function call to test different examples.
    // ArrangeHorizontally() // Example to arrange Text elements horizontally
    // LoginPageWithLayout() // Example of a login page layout with constraints
    // CreateBarrierExample() // Example using barriers in ConstraintLayout
    CreateChainExample() // Example demonstrating chains in ConstraintLayout
}

@Composable
fun Example1() {
    // Demonstrates basic usage of ConstraintLayout with three colored boxes
    ConstraintLayout(
        modifier = Modifier.fillMaxSize() // Fills the entire screen
    ) {
        // Creates references for the three boxes
        val (box1, box2, box3) = createRefs()

        // First Box: Red color, positioned at the top-left corner
        Box(
            modifier = Modifier
                .size(150.dp) // Specifies the size of the box
                .background(Color.Red) // Sets the background color
                .constrainAs(box1) {
                    start.linkTo(parent.start) // Links start to parent start
                    top.linkTo(parent.top) // Links top to parent top
                }
        )
        // Second Box: Yellow color, positioned to the right of the first box
        Box(
            modifier = Modifier
                .size(100.dp) // Specifies the size
                .background(Color.Yellow) // Sets the background color
                .constrainAs(box2) {
                    start.linkTo(box1.end, margin = 16.dp) // Start linked to box1 end with margin
                    top.linkTo(box1.top) // Aligns top with box1
                }
        )
        // Third Box: Blue color, positioned to the right of the second box
        Box(
            modifier = Modifier
                .size(50.dp) // Specifies the size
                .background(Color.Blue) // Sets the background color
                .constrainAs(box3) {
                    start.linkTo(box2.end, margin = 16.dp) // Start linked to box2 end with margin
                    top.linkTo(box2.top) // Aligns top with box2
                }
        )
    }
}

@Composable
fun ArrangeHorizontally() {
    // Arranges three text elements horizontally using ConstraintLayout
    ConstraintLayout(
        modifier = Modifier.fillMaxSize() // Fills the screen
    ) {
        // Creates references for the text elements
        val (text1, text2, text3) = createRefs()

        // First Text: Positioned on the left
        Text(
            text = "Text One",
            modifier = Modifier.constrainAs(text1) {
                start.linkTo(parent.start) // Start linked to parent start
                top.linkTo(parent.top) // Centered vertically by linking top
                bottom.linkTo(parent.bottom) // and bottom to parent
            }
        )
        // Second Text: Positioned to the right of the first text
        Text(
            text = "Text Two",
            modifier = Modifier.constrainAs(text2) {
                start.linkTo(text1.end, margin = 16.dp) // Start linked to text1 end with margin
                top.linkTo(text1.top) // Vertically aligned with text1
                bottom.linkTo(text1.bottom) // Same bottom alignment as text1
            }
        )
        // Third Text: Positioned to the right of the second text
        Text(
            text = "Text Three",
            modifier = Modifier.constrainAs(text3) {
                start.linkTo(text2.end, margin = 16.dp) // Start linked to text2 end with margin
                top.linkTo(text2.top) // Vertically aligned with text2
                bottom.linkTo(text2.bottom) // Same bottom alignment as text2
            }
        )
    }
}

@Composable
fun LoginPageWithLayout() {
    // Creates a login page layout using ConstraintLayout
    val usernameState = remember { mutableStateOf("") } // State for username input
    val passwordState = remember { mutableStateOf("") } // State for password input

    // Defines constraints for username, password, and button
    val constraints = ConstraintSet {
        val username = createRefFor("username") // Reference for username TextField
        val password = createRefFor("password") // Reference for password TextField
        val button = createRefFor("button") // Reference for login button

        // Constraints for username TextField
        constrain(username) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(parent.top, margin = 16.dp) // Positioned near the top
            bottom.linkTo(parent.bottom)
        }
        // Constraints for password TextField
        constrain(password) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(username.bottom, margin = 10.dp) // Positioned below username
        }
        // Constraints for login button
        constrain(button) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(password.bottom, margin = 10.dp) // Positioned below password
        }
    }

    // Displays the login page layout
    Box(
        modifier = Modifier.fillMaxSize() // Fills the screen
    ) {
        ConstraintLayout(
            constraintSet = constraints, // Applies the defined constraints
            modifier = Modifier.fillMaxSize() // Fills the screen
        ) {
            // Username TextField
            TextField(
                value = usernameState.value, // Binds username state
                onValueChange = { usernameState.value = it }, // Updates state on input
                modifier = Modifier.layoutId("username"), // Assigns layout ID
                label = { Text(text = "Username") } // Label for TextField
            )
            // Password TextField
            TextField(
                value = passwordState.value, // Binds password state
                onValueChange = { passwordState.value = it }, // Updates state on input
                modifier = Modifier.layoutId("password"), // Assigns layout ID
                visualTransformation = PasswordVisualTransformation(), // Hides input for passwords
                label = { Text(text = "Password") } // Label for TextField
            )
            // Login Button
            androidx.compose.material3.Button(
                onClick = { /* Handle Login Logic */ },
                modifier = Modifier.layoutId("button") // Assigns layout ID
            ) {
                Text(text = "Login") // Button text
            }
        }
    }
}

@Composable
fun GuideLineExample() {
    // Creates a guideline and aligns a Text to it in ConstraintLayout
    ConstraintLayout(
        modifier = Modifier.fillMaxWidth() // Fills the screen width
    ) {
        val (text1) = createRefs() // Reference for the text element
        val createGuideTop = createGuidelineFromTop(40.dp) // Creates a guideline 40 dp from the top
        Text(
            text = "Some Contents",
            modifier = Modifier.constrainAs(text1) {
                start.linkTo(parent.start) // Aligns start to parent start
                end.linkTo(parent.end) // Aligns end to parent end
                top.linkTo(createGuideTop) // Aligns top to the guideline
            }
        )
    }
}

@Composable
fun CreateBarrierExample() {
    // Creates a barrier to align elements based on the rightmost or bottommost item
    ConstraintLayout(
        modifier = Modifier.fillMaxWidth().padding(30.dp) // Fills width with padding
    ) {
        val (text1, text2, text3) = createRefs() // References for three text elements
        val barrierEnd = createEndBarrier(text1, text2) // Creates a barrier based on the end of text1 and text2

        // Text 1
        Text(
            text = "Text One Contents",
            modifier = Modifier.constrainAs(text1) {
                start.linkTo(parent.start) // Aligns start to parent start
                top.linkTo(parent.top) // Aligns top to parent top
            }
        )
        // Text 2
        Text(
            text = "Text Two Contents",
            modifier = Modifier.constrainAs(text2) {
                start.linkTo(parent.start) // Aligns start to parent start
                top.linkTo(text1.bottom) // Positioned below text1
            }
        )
        // Text 3: Aligned based on the barrier
        Text(
            text = "Text Three Contents",
            modifier = Modifier.constrainAs(text3) {
                start.linkTo(barrierEnd) // Aligned to the end barrier
                top.linkTo(parent.top) // Positioned at the top
            }
        )
    }
}

@Composable
fun CreateChainExample() {
    // Creates horizontal and vertical chains of text elements
    ConstraintLayout(
        modifier = Modifier.fillMaxSize().padding(20.dp) // Fills the screen with padding
    ) {
        val (text1, text2, text3) = createRefs() // References for text elements

        // Creates a horizontal chain
        createHorizontalChain(
            text1,
            text2,
            text3,
            chainStyle = ChainStyle.Packed // Packed style for closer alignment
        )
        // Creates a vertical chain
        createVerticalChain(
            text1,
            text2,
            text3
        )

        // Text 1
        Text(
            text = "text 1",
            modifier = Modifier.constrainAs(text1) {
                start.linkTo(parent.start) // Aligns start to parent start
                top.linkTo(parent.top) // Aligns top to parent top
            }
        )

        // Text 2
        Text(
            text = "text 2",
            modifier = Modifier.constrainAs(text2) {
                start.linkTo(text1.end) // Aligns start to the end of text1
                top.linkTo(text1.top) // Aligns top to text1's top
                bottom.linkTo(text1.bottom) // Aligns bottom to text1's bottom
            }
        )

        // Text 3
        Text(
            text = "text 3",
            modifier = Modifier.constrainAs(text3) {
                start.linkTo(text2.end) // Aligns start to the end of text2
                top.linkTo(text2.top) // Aligns top to text2's top
                bottom.linkTo(text1.bottom) // Aligns bottom to text1's bottom
            }
        )
    }
}
