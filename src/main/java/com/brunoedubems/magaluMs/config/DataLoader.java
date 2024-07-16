package com.brunoedubems.magaluMs.config;

import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.brunoedubems.magaluMs.entity.Channel;
import com.brunoedubems.magaluMs.entity.Status;
import com.brunoedubems.magaluMs.repository.ChannelRepository;
import com.brunoedubems.magaluMs.repository.StatusRepository;

@Component
public class DataLoader implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(DataLoader.class);

    private final ChannelRepository channelRepository;
    private final StatusRepository statusRepository;

    public DataLoader(ChannelRepository channelRepository, StatusRepository statusRepository) {
        this.channelRepository = channelRepository;
        this.statusRepository = statusRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Iniciando o carregamento de dados...");

        Arrays.stream(Channel.Values.values())
              .map(Channel.Values::toChannel)
              .forEach(channelRepository::save);

        Arrays.stream(Status.Values.values())
              .map(Status.Values::toStatus)
              .forEach(statusRepository::save);

    }
}
