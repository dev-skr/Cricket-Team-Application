package com.example.player.service;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.http.HttpStatus;
 import org.springframework.stereotype.Service;
 import org.springframework.web.server.ResponseStatusException;
 import java.util.*;
 import com.example.player.repository.PlayerJpaRepository;
  import com.example.player.repository.PlayerRepository;
  import com.example.player.model.Player;

 @Service
 public class PlayerJpaService implements PlayerRepository{
    @Autowired
    public PlayerJpaRepository playerRepo;
@Override
public ArrayList<Player> getPlayers(){
    List<Player> temp= playerRepo.findAll();
    ArrayList<Player> players=new ArrayList<>(temp);
    return players;
}

@Override
public Player getPlayerById(int id){
try{
    Player player=playerRepo.findById(id).get();
    return player;
}catch(Exception e){
    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
}
}

@Override
public Player addPlayer(Player player){
    Player postedPlayer =playerRepo.save(player);
    return postedPlayer;
}

@Override
public Player updatePlayer(int id,Player player){
    try{
    Player exist=getPlayerById(id);

    if(player.getPlayerName() !=null)
    exist.setPlayerName(player.getPlayerName());

    if(player.getJerseyNumber() !=0)
    exist.setJerseyNumber(player.getJerseyNumber());

    if(player.getRole() !=null)
    exist.setRole(player.getRole());

    playerRepo.save(exist);

    return exist;
    }catch (Exception e){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

}

@Override
public void deletePlayer(int id){
try{
    Player player=getPlayerById(id);
    playerRepo.deleteById(id);
}catch(Exception e){
     throw new ResponseStatusException(HttpStatus.NOT_FOUND);
}
}

 }