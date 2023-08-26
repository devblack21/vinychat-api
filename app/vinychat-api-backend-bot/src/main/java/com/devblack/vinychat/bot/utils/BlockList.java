package com.devblack.vinychat.bot.utils;


import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class BlockList {

    private final Resource resource = new ClassPathResource("block-list.txt");
    private final Set<String> BLOCK_LIST = new HashSet<>();

    final Locale localeBr = new Locale("pt", "BR");

    public BlockList() {
        enrichBlockList();
    }

    @SneakyThrows
    private void enrichBlockList() {
        final InputStream inputStream = resource.getInputStream();
        byte[] bdata = FileCopyUtils.copyToByteArray(inputStream);
        final String content = new String(bdata, StandardCharsets.ISO_8859_1);
        BLOCK_LIST.addAll(Arrays.stream(treatContent(content)).collect(Collectors.toSet()));
    }

    public boolean contains(final String str) {
        final String value = StringUtils.lowerCase(StringUtils.isNotBlank(str) ? str : StringUtils.EMPTY, localeBr);
        return BLOCK_LIST.stream().map(valor -> StringUtils.lowerCase(valor, localeBr)).anyMatch(value::contains);
    }

    private String[] treatContent(final String value) {

        String content = value;

        content = StringUtils.trim(content);
        content = StringUtils.remove(content, "\n");

        return StringUtils.split(content, ";");
    }



}
