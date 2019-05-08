/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.EmptyCellException;
import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IChess.ChessColor;
import fr.rphstudio.chess.interf.OutOfBoardException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author leducmaxime
 */
public class KnightMove implements IMove{

        // To do
    
    @Override
    public List<IChess.ChessPosition> getMovePiece(IChess.ChessPosition _p, Board _board) {
        
       
            List<IChess.ChessPosition> canMoveHere;
            canMoveHere = new ArrayList<IChess.ChessPosition>();
           try {  
            ChessColor myColor  = _board.GetChessColorInBoard(_p);
           
            
            // Pawn can't move on other Piece and can't move out of Array
            int x = _p.x+1;
            int y =_p.y+2;
            if((x< IChess.BOARD_WIDTH && y < IChess.BOARD_HEIGHT)&&(x >= 0 && y >= 0 )&& ( _board.isCellNotEmpty(new IChess.ChessPosition(x,y)) == false || myColor != _board.GetChessColorInBoard(new IChess.ChessPosition(x,y)) )){
                canMoveHere.add(new IChess.ChessPosition(x,y));
            }
            x = _p.x+1;
            y = _p.y-2;
            if((x < IChess.BOARD_WIDTH && y < IChess.BOARD_HEIGHT)&&(x >= 0 && y >= 0 )&& ( _board.isCellNotEmpty(new IChess.ChessPosition(x,y)) == false || myColor != _board.GetChessColorInBoard(new IChess.ChessPosition(x,y)))){
                canMoveHere.add(new IChess.ChessPosition(x,y));
            }
            x = _p.x-1;
            y = _p.y-2;
            if((x < IChess.BOARD_WIDTH && y < IChess.BOARD_HEIGHT)&&(x >= 0 && y >= 0 )&& ( _board.isCellNotEmpty(new IChess.ChessPosition(x,y)) == false || myColor != _board.GetChessColorInBoard(new IChess.ChessPosition(x,y)))){
                canMoveHere.add(new IChess.ChessPosition(x,y));
            }
            x = _p.x-1;
            y =_p.y+2;
            if((x < IChess.BOARD_WIDTH && y < IChess.BOARD_HEIGHT)&&(x >= 0 && y >= 0 )&& ( _board.isCellNotEmpty(new IChess.ChessPosition(x,y)) == false || myColor != _board.GetChessColorInBoard(new IChess.ChessPosition(x,y)))){
                canMoveHere.add(new IChess.ChessPosition(x,y));
            }
            x = _p.x+2;
            y = _p.y+1;
            if((x < IChess.BOARD_WIDTH && y < IChess.BOARD_HEIGHT)&&(x >= 0 && y >= 0 )&& ( _board.isCellNotEmpty(new IChess.ChessPosition(x,y)) == false || myColor != _board.GetChessColorInBoard(new IChess.ChessPosition(x,y)))){
                canMoveHere.add(new IChess.ChessPosition(x,y));
            }
            x = _p.x+2;
            y = _p.y-1;
            if((x < IChess.BOARD_WIDTH && y < IChess.BOARD_HEIGHT)&&(x >= 0 && y >= 0 )&& ( _board.isCellNotEmpty(new IChess.ChessPosition(x,y)) == false || myColor != _board.GetChessColorInBoard(new IChess.ChessPosition(x,y)))){
                canMoveHere.add(new IChess.ChessPosition(x,y));
            }
            x = _p.x-2;
            y = _p.y+1;
            if((x < IChess.BOARD_WIDTH && y < IChess.BOARD_HEIGHT)&&(x >= 0 && y >= 0 )&& ( _board.isCellNotEmpty(new IChess.ChessPosition(x,y)) == false || myColor != _board.GetChessColorInBoard(new IChess.ChessPosition(x,y)))){
                canMoveHere.add(new IChess.ChessPosition(x,y));
            }
            x = _p.x-2;
            y = _p.y-1;
            if((x < IChess.BOARD_WIDTH && y < IChess.BOARD_HEIGHT)&&(x >= 0 && y >= 0 )&& ( _board.isCellNotEmpty(new IChess.ChessPosition(x,y)) == false || myColor != _board.GetChessColorInBoard(new IChess.ChessPosition(x,y)))){
                canMoveHere.add(new IChess.ChessPosition(x,y));
            }
            
            
        } catch (EmptyCellException ex) {
            Logger.getLogger(KnightMove.class.getName()).log(Level.SEVERE, null, ex);
        } catch (OutOfBoardException ex) {
            Logger.getLogger(KnightMove.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return canMoveHere;
    }
}
    

