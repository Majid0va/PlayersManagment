package atl.practice.thymeleafPractice.service.impl;

import atl.practice.thymeleafPractice.mapper.PlayerMapper;
import atl.practice.thymeleafPractice.model.Players;
import atl.practice.thymeleafPractice.repository.PlayerRepository;
import atl.practice.thymeleafPractice.request.PlayersRequest;
import atl.practice.thymeleafPractice.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository playerRepository;

    private final Path root = Paths.get("img");

    @Override
    public List<PlayersRequest> findAll() {
        List<Players> employees = playerRepository.findAll();
        return employees.stream()
                .map(employee -> PlayerMapper.INSTANCE.modelToDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public void save(PlayersRequest players) {

        Players players1 = PlayerMapper.INSTANCE.dtoToModel(players);
        players1.setImage(players.getImage().getOriginalFilename());
        playerRepository.save(players1);

    }

    @Override
    public PlayersRequest findById(Long id) {
        Optional<Players> players = playerRepository.findById(id);
        PlayersRequest playersRequest = PlayerMapper.INSTANCE.modelToDto(players.get());

        return playersRequest;
    }

    @Override
    public void deleteById(long id) {
        playerRepository.deleteById(id);
    }

    @Override
    public Players update(PlayersRequest players) {
        Players players1 = PlayerMapper.INSTANCE.dtoToModel(players);
        return playerRepository.save(players1);
    }
}