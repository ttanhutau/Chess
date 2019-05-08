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
import fr.rphstudio.chess.interf.OutOfBoardException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author leducmaxime
 */
public class PawnMove implements IMove{

    @Override
    public List<IChess.ChessPosition> getMovePiece(IChess.ChessPosition _p, Board _board)
    {
        try {
            // create new List for stock where Piece can move
            List<IChess.ChessPosition> canMoveHere;
            canMoveHere = new ArrayList<IChess.ChessPosition>();

            ChessColor myColor = _board.GetChessColorInBoard(_p);
            int step;

            if(myColor == ChessColor.CLR_BLACK){
                step = 1;
            }else{
                step = -1;
            }
            
            int nbTurn = _board.getNbTurnPiece(_p);
            boolean targetNull = _board.isCellNotEmpty(new ChessPosition(_p.x,_p.y+step));
            
            if(_p.y+step >=0 && _p.y+step < IChess.BOARD_HEIGHT){
                if(targetNull == false){
                    canMoveHere.add(new ChessPosition(_p.x,_p.y+step));
                }
                if(targetNull == false &&  nbTurn <= 0){
                    canMoveHere.add(new ChessPosition(_p.x,_p.y+(step *2)));
                }
            }
            
            ChessColor targetColor = _board.GetChessColorInBoard(new ChessPosition(_p.x+1,_p.y+step));
            
            // Pawn can't move on other Piece and can't move out of Array
            
                
            

            return canMoveHere;
        } catch (EmptyCellException ex) {
            Logger.getLogger(PawnMove.class.getName()).log(Level.SEVERE, null, ex);
        } catch (OutOfBoardException ex) {
            Logger.getLogger(PawnMove.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<IChess.ChessPosition>();
    }

}
