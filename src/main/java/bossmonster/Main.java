package bossmonster;

import bossmonster.controller.MainController;
import bossmonster.repository.MemoryRepository;
import bossmonster.service.RepositoryService;

public class Main {
    public static void main(String[] args) {
        new MainController(new RepositoryService(MemoryRepository.getInstance())).run();
    }
}
