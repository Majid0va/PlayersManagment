package atl.practice.thymeleafPractice.service;

import atl.practice.thymeleafPractice.model.Players;
import atl.practice.thymeleafPractice.request.PlayersRequest;

import java.util.List;


public interface PlayerService {
    List<PlayersRequest> findAll();

    void save(PlayersRequest playersRequest);


    PlayersRequest findById(Long id);

    void deleteById(long id);

    Players update(PlayersRequest players);


}
