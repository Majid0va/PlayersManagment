package atl.practice.thymeleafPractice.controller;

import atl.practice.thymeleafPractice.request.PlayersRequest;
import atl.practice.thymeleafPractice.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;

    @GetMapping("/players")
    public String listPlayers(Model model) {
        model.addAttribute("players", playerService.findAll());
        return "page1";
    }

    @GetMapping("/players/new")
    public String createPlayersForm(Model model) {
        PlayersRequest players = new PlayersRequest();
        model.addAttribute("player", players);
        return "page2";

    }


    @PostMapping("/players")
    public String savePlayer(@ModelAttribute("player") PlayersRequest player) {
        String fileName = StringUtils.cleanPath(player.getImage().getOriginalFilename());
        playerService.save(player);
        return "redirect:/players";
    }

    @GetMapping("/players/edit/{id}")
    public String editPlayerForm(@PathVariable Long id, Model model) {
        model.addAttribute("player", playerService.findById(id));
        return "page3";
    }

    @PostMapping("/players/{id}")
    public String updatePlayer(@PathVariable Long id, @ModelAttribute("player") PlayersRequest player, Model model) {

        PlayersRequest existingPlayer = playerService.findById(id);
        existingPlayer.setId(id);
        existingPlayer.setName(player.getName());
        existingPlayer.setNumber(player.getNumber());
        existingPlayer.setTeam(player.getTeam());

        playerService.update(existingPlayer);
        return "redirect:/players";
    }


    @GetMapping("/players/{id}")
    public String deletePlayer(@PathVariable Long id) {
        playerService.deleteById(id);
        return "redirect:/players";
    }


}
