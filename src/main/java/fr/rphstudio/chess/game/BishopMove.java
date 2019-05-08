/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.EmptyCellException;
import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.OutOfBoardException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author leducmaxime
 */
public class BishopMove implements IMove{
    
    // To do

    @Override
    public List<IChess.ChessPosition> getMovePiece(IChess.ChessPosition _p, Board _board) {
            List<IChess.ChessPosition> canMoveHere;
            canMoveHere = new ArrayList<IChess.ChessPosition>();
           try {  
            IChess.ChessColor myColor  = _board.GetChessColorInBoard(_p);
           
            int x = _p.x;
            int y =_p.y;
            boolean isCollide = false;
            // Pawn can't move on other Piece of his color and can't move out of Array
            for(int i = 0; i <= 3;i++){
                int dX;
                int dY;
                
                int j = 1; 
                if(i % 2 == 0)
                {
                     dX = -1;
                } else
                {
                     dX = 1;
                }
                if(i <2)
                {
                    dY = -1; 
                }else
                {
                   dY = 1;  
                }
            while(j <= 7)
            {  
                if((x+(dX*j) < IChess.BOARD_WIDTH && y+(dY*j) < IChess.BOARD_HEIGHT)&&(x+(dX*j) >= 0 && y+(dY*j) >= 0 ) ){
                    if( _board.isCellNotEmpty(new IChess.ChessPosition(x+(dX*j),y+(dY*j))) == false ){
                        canMoveHere.add(new IChess.ChessPosition(x+(dX*j),y+(dY*j)));
                    }
                    else if(myColor != _board.GetChessColorInBoard(new IChess.ChessPosition(x+(dX*j), y+(dY*j))))
                    {
                        canMoveHere.add(new IChess.ChessPosition(x+(dX*j),y+(dY*j)));
                        break;
                    }
                    else
                    {
                        break;
                    }
                }
             j++;
            }
            
        }
            
        } catch (EmptyCellException ex) {
            Logger.getLogger(KnightMove.class.getName()).log(Level.SEVERE, null, ex);
        } catch (OutOfBoardException ex) {
            Logger.getLogger(KnightMove.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return canMoveHere;
    
    }
}
    

