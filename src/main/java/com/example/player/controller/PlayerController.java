package com.example.player.controller;
 import org.springframework.web.bind.annotation.*;
 import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.player.model.Player;
import com.example.player.service.PlayerJpaService;
@RestController
public class PlayerController {
    @Autowired
    public PlayerJpaService service;

    @GetMapping("/players")
public ArrayList<Player> getAllPlayers(){
return service.getPlayers();
}

@PostMapping("/players")
public Player createPlayer(@RequestBody Player player){
    return service.addPlayer(player);
}

@GetMapping("/players/{playerId}")
public Player getPlayer(@PathVariable("playerId") int id){
    return service.getPlayerById(id);
}

@PutMapping("/players/{playerId}")
public Player putPlayer(@PathVariable("playerId")  int id, @RequestBody Player player){
    return service.updatePlayer(id,player);
}

@DeleteMapping("/players/{playerId}")
public void deletePlayer(@PathVariable("playerId")  int id){
    service.deletePlayer(id);
}

}