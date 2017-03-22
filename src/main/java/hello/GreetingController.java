package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("game")
public class GreetingController {
    @GetMapping("/greeting")
    public String greetingForm(Model m) {
        Game g = new Game();
        int condition = g.init();
        m.addAttribute("game", g);
        switch (condition) {
            case -1:
                m.addAttribute("result", "you lose");
                return "result";
            case 1:
                m.addAttribute("result", "you win");
                return "result";
        }

        return "game";
    }

    @PostMapping("/greeting")
    public String playerStage(Model model, HttpSession session) {
        Game g = (Game) session.getAttribute("game");
        boolean playerWins = g.playerStage();
        model.addAttribute("game", g);
        if (!playerWins) {
            model.addAttribute("result", "you lose");
            return "result";
        }
        return "game";
    }

    @PostMapping("/dealer")
    public String dealerStage(Model m, HttpSession session) {
        Game game = (Game) session.getAttribute("game");
        boolean dealerWins = game.dealerStage();
        if (!dealerWins) {
            m.addAttribute("result", "you win");
            return "result";
        }
        int condition = game.getResult();
        System.out.println(condition);
        switch (condition) {
            case -1:
                m.addAttribute("result", "you lose");
                break;
            case 0:
                m.addAttribute("result", "draw");
                break;
            case 1:
                m.addAttribute("result", "you win");
                break;
        }
        return "result";
    }

}
