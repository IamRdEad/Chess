const boardState = [
    ['R', 'N', 'B', 'Q', 'K', 'B', 'N', 'R'],
    ['P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'],
    [' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '],
    [' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '],
    [' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '],
    [' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '],
    ['p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'],
    ['r', 'n', 'b', 'q', 'k', 'b', 'n', 'r']
];
document.addEventListener('DOMContentLoaded', () => {
    const chessboard = document.getElementById('chessboard');

    if (chessboard) {
        for (let row = 0; row < 8; row++) {
            for (let col = 0; col < 8; col++) {
                const square = document.createElement('div');
                square.classList.add('square');

                if ((row + col) % 2 === 0) {
                    square.classList.add('white');
                } else {
                    square.classList.add('black');
                }

                const piece = boardState[row][col];
                if (piece !== ' ') {
                    const pieceElement = document.createElement('div');
                    pieceElement.classList.add('piece', piece);
                    square.appendChild(pieceElement);
                }

                chessboard.appendChild(square);
            }
        }
    }
});
