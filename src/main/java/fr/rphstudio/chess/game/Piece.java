/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess.ChessColor;
import fr.rphstudio.chess.interf.IChess.ChessPosition;
import fr.rphstudio.chess.interf.IChess.ChessType;
import java.util.List;

/**
 *
 * @author leducmaxime
 */
public class Piece {

    private ChessColor chessColor;
    private ChessType chessType;

    private IMove move;

    private int currentNbTurn;

    // create the piece
    public Piece(ChessColor _color, ChessType _type, IMove _move){
        this.chessColor = _color;
        this.chessType = _type;
        this.move = _move;

        currentNbTurn = 0;

    }

    public Piece(ChessColor _color, ChessType _type){
        this.chessColor = _color;
        this.chessType = _type;
    }
    // return the color of the piece
    public ChessColor getChessColor(){
        return this.chessColor;
    }
    // return the type of the piece
    public ChessType getChessType(){
        return this.chessType;
    }
    // return ArrayList whith all possible move
    public List<ChessPosition> getPieceMove(ChessPosition _p, Board _board){
        return move.getMovePiece(_p,_board);
    }

    public void increaseNbTurn(){
        this.currentNbTurn++;
        System.out.println(this.chessType +" "+this.chessColor+" "+ this.currentNbTurn);

    }

    public int getNbTurn(){
        return this.currentNbTurn;
    }
}
