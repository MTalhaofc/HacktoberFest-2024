#include <iostream>
#include <conio.h> // For _kbhit() and _getch()
#include <windows.h> // For Sleep()
#include <vector>
using namespace std;

bool gameOver;
const int width = 20;
const int height = 20;
int x, y, fruitX, fruitY, score;
enum eDirection { STOP = 0, LEFT, RIGHT, UP, DOWN };
eDirection dir;

vector<pair<int, int>> snake; // Vector to hold snake body coordinates

void Setup() {
    gameOver = false;
    dir = STOP;
    x = width / 2;
    y = height / 2;
    fruitX = rand() % width;
    fruitY = rand() % height;
    score = 0;
    snake.push_back(make_pair(x, y)); // Initialize snake with one segment
}

void Draw() {
    system("cls"); // Clear console
    for (int i = 0; i < width + 2; i++)
        cout << "#";
    cout << endl;

    for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
            if (j == 0)
                cout << "#"; // Walls
            if (i == y && j == x)
                cout << "O"; // Snake head
            else if (i == fruitY && j == fruitX)
                cout << "F"; // Fruit
            else {
                bool print = false;
                for (auto s : snake) {
                    if (s.first == j && s.second == i) {
                        cout << "o"; // Snake body
                        print = true;
                    }
                }
                if (!print)
                    cout << " ";
            }
            if (j == width - 1)
                cout << "#";
        }
        cout << endl;
    }

    for (int i = 0; i < width + 2; i++)
        cout << "#";
    cout << endl;
    cout << "Score: " << score << endl;
}

void Input() {
    if (_kbhit()) {
        switch (_getch()) {
        case 'a':
            dir = LEFT;
            break;
        case 'd':
            dir = RIGHT;
            break;
        case 'w':
            dir = UP;
            break;
        case 's':
            dir = DOWN;
            break;
        case 'x':
            gameOver = true; // Exit game
            break;
        }
    }
}

void Logic() {
    int prevX = snake[0].first; // Previous head position
    int prevY = snake[0].second;
    int prev2X, prev2Y;

    switch (dir) {
    case LEFT:
        x--;
        break;
    case RIGHT:
        x++;
        break;
    case UP:
        y--;
        break;
    case DOWN:
        y++;
        break;
    }

    // Check for wall collision
    if (x >= width) x = 0; else if (x < 0) x = width - 1;
    if (y >= height) y = 0; else if (y < 0) y = height - 1;

    // Check for fruit collision
    if (x == fruitX && y == fruitY) {
        score += 10; // Increase score
        fruitX = rand() % width; // Respawn fruit
        fruitY = rand() % height;

        // Grow snake
        snake.push_back(make_pair(prevX, prevY));
    }

    for (size_t i = 1; i < snake.size(); i++) {
        prev2X = snake[i].first; // Store previous segment position
        prev2Y = snake[i].second;

        snake[i].first = prevX; // Move the segment forward
        snake[i].second = prevY;

        prevX = prev2X; // Update previous position
        prevY = prev2Y;

        // Check self-collision
        if (snake[i].first == x && snake[i].second == y) 
            gameOver = true;
    }

    snake[0] = make_pair(x, y); // Update head position
}

int main() {
    Setup();
    
    while (!gameOver) {
        Draw();
        Input();
        Logic();
        Sleep(100); // Control game speed
    }

    return 0;
}
