/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IChess.ChessPosition;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leducmaxime
 */
public class RookMove implements IMove{

    @Override
    public List<IChess.ChessPosition> getMovePiece(ChessPosition _p, Board _board) {
        // create new List for stock where Piece can move
        List<IChess.ChessPosition> canMoveHere;
        canMoveHere = new ArrayList<ChessPosition>();
        
        // to do
        // Pawn can't move on other Piece and can't move out of Array
        for (int X = 0; X < IChess.BOARD_WIDTH; X++) {
            int xTmp = _p.x+X;
            if(xTmp >=0 && xTmp < IChess.BOARD_WIDTH){
                canMoveHere.add(new ChessPosition(xTmp,_p.y));
            }
            xTmp = _p.x-X;
            if(xTmp >=0 && xTmp < IChess.BOARD_WIDTH){
                canMoveHere.add(new ChessPosition(xTmp,_p.y));
            }
        }
        for (int X = 0; X < IChess.BOARD_HEIGHT; X++) {
            int yTmp = _p.y+X;
            if(yTmp >=0 && yTmp < IChess.BOARD_HEIGHT){
                canMoveHere.add(new ChessPosition(_p.x,yTmp));
            }
            yTmp = _p.y-X;
            if(yTmp >=0 && yTmp < IChess.BOARD_HEIGHT){
                canMoveHere.add(new ChessPosition(_p.x,yTmp));
            }
        }
            /*for (int X = 0; X < IChess.BOARD_WIDTH; X++) {
            for (int dx = -X; dx <= X; dx += 2) {
                int yTmp = _p.y+dx;
                if(yTmp >=0 && yTmp < IChess.BOARD_WIDTH){
                    canMoveHere.add(new ChessPosition(_p.x,yTmp));
                }
            }
        }*/
        return canMoveHere;
    }
    
}
