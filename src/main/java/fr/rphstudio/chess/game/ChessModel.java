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

/**
 *
 * @author leducmaxime
 */
public class ChessModel implements IChess {

    static IChess instance;
    
    private Board board;
    
    // create the ChessModel
    private ChessModel(){
        board = new Board(IChess.BOARD_HEIGHT,IChess.BOARD_WIDTH);
    }
    
    // return the instance and if instance == null create new instance else just return instance
    public static IChess getInstance() {
        
        if(instance == null)
        {
            instance = new ChessModel();
        }
        return instance;
    }

    @Override
    public void reinit() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ChessType getPieceType(ChessPosition p) throws EmptyCellException, OutOfBoardException {
        return board.GetChessTypeInBoard(p);
    }
    @Override
    public ChessColor getPieceColor(ChessPosition p) throws EmptyCellException, OutOfBoardException {
        return board.GetChessColorInBoard(p);
    }

    @Override
    public int getNbRemainingPieces(ChessColor color) {
        return board.GetNbPiecesByColor(color);
    }

    @Override
    public List<ChessPosition> getPieceMoves(ChessPosition p) {
       return board.GetPieceToMove(p);
    }

    @Override
    public void movePiece(ChessPosition p0, ChessPosition p1) {
       board.SetNbTurnPiece(p0);
       board.movePiece(p0, p1);
    }

    @Override
    public ChessKingState getKingState(ChessColor color) {
        return ChessKingState.KING_SAFE;
    }

    @Override
    public List<ChessType> getRemovedPieces(ChessColor color) {
        return new ArrayList<ChessType>();
    }

    @Override
    public boolean undoLastMove() {
       return false;
    }

    @Override
    public long getPlayerDuration(ChessColor color, boolean isPlaying) {
        return 0;
    }
    
}
