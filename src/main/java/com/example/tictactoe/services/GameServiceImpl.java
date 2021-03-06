package com.example.tictactoe.services;

import com.example.tictactoe.models.Game;
import com.example.tictactoe.repositories.GameRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;

    @Override
    public Game getGame() {
        return ((ArrayList<Game>) gameRepository.findAll()).get(0);
    }

    @Override
    public String makeMove(String coordinates) {
        if(validateInputs(coordinates)){
            int row = coordinates.charAt(0) - 'a';
            int column = Integer.parseInt(coordinates.substring(1));
            int location = row * 3 + column;
            if(validateMove(location)){
                Game game = getGame();
                int value = game.getCurrentPlayerId() == 1 ? 1 : -1;
                game.getBoard().setGrid(location, value);
                game.setCurrentPlayerId(game.getCurrentPlayerId() == 1 ? 2 : 1);
                game.setGameStatus();
                gameRepository.save(game);
                return "Good move";
            }
            return "ALREADY OCCUPIED " + coordinates;
        }
        return "INVALID COORDINATES " + coordinates;
    }

    @Override
    public Boolean validateMove(int location) {
        if(location >= 0 && location < 9){
            return getGame().getBoard().getGrid().get(location) == 0;
        }
        else{
            throw new IndexOutOfBoundsException("Invalid input " + location);
        }
    }

    @Override
    public Boolean validateInputs(String coordinates) {
        try{
            int column = Integer.parseInt(coordinates.substring(1));
            int row = coordinates.charAt(0) - 'a';
            return coordinates.length() == 2 && row <3 && row >=0 && column <3 && column >=0;
        }
        catch(Exception e){
            return false;
        }
    }

    @Override
    public String board() {
        return getGame().getBoard().toString();
    }

    @Override
    public String gameStatus() {
        return getGame().getGameStatus().toString();
    }
}
