/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IChess.ChessPosition;
import java.util.List;

/**
 *
 * @author leducmaxime
 */
public interface IMove {
   
    public List<ChessPosition> getMovePiece(IChess.ChessPosition _p, Board _board);
    
}
