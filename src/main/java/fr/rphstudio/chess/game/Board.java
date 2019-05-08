/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.EmptyCellException;
import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IChess.ChessColor;
import fr.rphstudio.chess.interf.IChess.ChessPosition;
import fr.rphstudio.chess.interf.IChess.ChessType;
import fr.rphstudio.chess.interf.OutOfBoardException;
import java.util.List;

/**
 *
 * @author leducmaxime
 */
public class Board {

    private final Piece[][] boardArray;

    // create the board
    public Board(int _heigth,int _width){
        this.boardArray = new Piece[_heigth][_width];
        for (int i = 0; i < IChess.BOARD_WIDTH; i++) {
            // create Black Pawns
            this.boardArray[ChessModel.BOARD_POS_Y_BLACK_PAWNS][i] = new Piece(ChessColor.CLR_BLACK,ChessType.TYP_PAWN,new PawnMove());
            // create White Pawns
            this.boardArray[ChessModel.BOARD_POS_Y_WHITE_PAWNS][i] = new Piece(ChessColor.CLR_WHITE,ChessType.TYP_PAWN,new PawnMove());
        }
        // create Black Towers
        this.boardArray[ChessModel.BOARD_POS_Y_BLACK_PIECES][ChessModel.BOARD_POS_X_QUEENSIDE_ROOK] = new Piece(ChessColor.CLR_BLACK,ChessType.TYP_ROOK,new RookMove());
        this.boardArray[ChessModel.BOARD_POS_Y_BLACK_PIECES][ChessModel.BOARD_POS_X_KINGSIDE_ROOK] = new Piece(ChessColor.CLR_BLACK,ChessType.TYP_ROOK,new RookMove());
        // create White Towers
        this.boardArray[ChessModel.BOARD_POS_Y_WHITE_PIECES][ChessModel.BOARD_POS_X_QUEENSIDE_ROOK] = new Piece(ChessColor.CLR_WHITE,ChessType.TYP_ROOK,new RookMove());
        this.boardArray[ChessModel.BOARD_POS_Y_WHITE_PIECES][ChessModel.BOARD_POS_X_KINGSIDE_ROOK] = new Piece(ChessColor.CLR_WHITE,ChessType.TYP_ROOK,new RookMove());
        // create Black Horses
        this.boardArray[ChessModel.BOARD_POS_Y_BLACK_PIECES][ChessModel.BOARD_POS_X_QUEENSIDE_KNIGHT] = new Piece(ChessColor.CLR_BLACK,ChessType.TYP_KNIGHT,new KnightMove());
        this.boardArray[ChessModel.BOARD_POS_Y_BLACK_PIECES][ChessModel.BOARD_POS_X_KINGSIDE_KNIGHT] = new Piece(ChessColor.CLR_BLACK,ChessType.TYP_KNIGHT,new KnightMove());
        // create White Horses
        this.boardArray[ChessModel.BOARD_POS_Y_WHITE_PIECES][ChessModel.BOARD_POS_X_QUEENSIDE_KNIGHT] = new Piece(ChessColor.CLR_WHITE,ChessType.TYP_KNIGHT,new KnightMove());
        this.boardArray[ChessModel.BOARD_POS_Y_WHITE_PIECES][ChessModel.BOARD_POS_X_KINGSIDE_KNIGHT] = new Piece(ChessColor.CLR_WHITE,ChessType.TYP_KNIGHT,new KnightMove());
        // create Black Bishops
        this.boardArray[ChessModel.BOARD_POS_Y_BLACK_PIECES][ChessModel.BOARD_POS_X_QUEENSIDE_BISHOP] = new Piece(ChessColor.CLR_BLACK,ChessType.TYP_BISHOP,new BishopMove());
        this.boardArray[ChessModel.BOARD_POS_Y_BLACK_PIECES][ChessModel.BOARD_POS_X_KINGSIDE_BISHOP] = new Piece(ChessColor.CLR_BLACK,ChessType.TYP_BISHOP,new BishopMove());
        // create White Bishops
        this.boardArray[ChessModel.BOARD_POS_Y_WHITE_PIECES][ChessModel.BOARD_POS_X_QUEENSIDE_BISHOP] = new Piece(ChessColor.CLR_WHITE,ChessType.TYP_BISHOP,new BishopMove());
        this.boardArray[ChessModel.BOARD_POS_Y_WHITE_PIECES][ChessModel.BOARD_POS_X_KINGSIDE_BISHOP] = new Piece(ChessColor.CLR_WHITE,ChessType.TYP_BISHOP,new BishopMove());
        // create Black King
        this.boardArray[ChessModel.BOARD_POS_Y_BLACK_PIECES][ChessModel.BOARD_POS_X_QUEEN] = new Piece(ChessColor.CLR_BLACK,ChessType.TYP_QUEEN,new QueenMove());
        // create White King
        this.boardArray[ChessModel.BOARD_POS_Y_WHITE_PIECES][ChessModel.BOARD_POS_X_QUEEN] = new Piece(ChessColor.CLR_WHITE,ChessType.TYP_QUEEN,new QueenMove());
        // create Black Queen
        this.boardArray[ChessModel.BOARD_POS_Y_BLACK_PIECES][ChessModel.BOARD_POS_X_KING] = new Piece(ChessColor.CLR_BLACK,ChessType.TYP_KING,new KingMove());
        // create White Queen
        this.boardArray[ChessModel.BOARD_POS_Y_WHITE_PIECES][ChessModel.BOARD_POS_X_KING] = new Piece(ChessColor.CLR_WHITE,ChessType.TYP_KING,new KingMove());

    }
    // return the color of the piece on the current position
    public ChessColor GetChessColorInBoard(ChessPosition _p) throws EmptyCellException, OutOfBoardException{
        if(_p.x  < 0 || _p.x >= IChess.BOARD_WIDTH || _p.y  < 0 || _p.x >= IChess.BOARD_HEIGHT){
            throw new OutOfBoardException();
        }
        if(boardArray[_p.y][_p.x] == null){
        throw new EmptyCellException();
        }
        return boardArray[_p.y][_p.x].getChessColor();
    }
    // return the type of the piece on the current position
    public ChessType GetChessTypeInBoard(ChessPosition _p) throws EmptyCellException, OutOfBoardException{
        if(_p.x  < 0 || _p.x >= IChess.BOARD_WIDTH || _p.y  < 0 || _p.x >= IChess.BOARD_HEIGHT){
            throw new OutOfBoardException();
        }
        if(boardArray[_p.y][_p.x] == null){
        throw new EmptyCellException();
        }
        return boardArray[_p.y][_p.x].getChessType();
    }

    public int GetNbPiecesByColor(ChessColor _color){
        int count = 0;
        for (int y = 0; y < IChess.BOARD_HEIGHT; y++) {
            for (int x = 0; x < IChess.BOARD_WIDTH; x++) {
                if(boardArray[y][x] != null){
                    if(boardArray[y][x].getChessColor() == _color)
                    count++;
                }
            }
        }
        return count;
    }
    // call Piece methode for return the List of chesspossition
    public List<ChessPosition> GetPieceToMove(ChessPosition _p){
        return boardArray[_p.y][_p.x].getPieceMove(_p, this);
    }
    // return if on the target position they are 1 piece or no
    public boolean isCellNotEmpty(IChess.ChessPosition _p){
        if(boardArray[_p.y][_p.x] != null){
            return true;
        }else
        return false;
    }

    public void SetNbTurnPiece(ChessPosition _p){
        if(boardArray[_p.y][_p.x] != null){
            boardArray[_p.y][_p.x].increaseNbTurn();
        }
    }
    public int getNbTurnPiece(ChessPosition _p){
        return boardArray[_p.y][_p.x].getNbTurn();
    }
    
    public void movePiece(ChessPosition _p0,ChessPosition _p1){
        boardArray[_p1.y][_p1.x] = boardArray[_p0.y][_p0.x];
        boardArray[_p0.y][_p0.x] = null; 
    }
}
