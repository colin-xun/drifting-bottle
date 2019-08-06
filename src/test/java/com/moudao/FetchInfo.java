package com.moudao;

import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.FFMPEGLocator;
import it.sauronsoftware.jave.MultimediaInfo;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * author: MrWang
 * date: 2018/7/3 22:46
 */
public class FetchInfo {
    private static final List<String> videoNames = Arrays.asList(".avi", ".mp4", ".mov", ".flv");
    private static final Pattern pattern = Pattern.compile("^\\d{8}");
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入根文件的绝对路径");
        String path = sc.nextLine();
        File file = new File(path);
        while(!file.exists()){
            System.out.println("此文件路径不存在，请重新输入,输入exit退出系统");
            path = sc.nextLine();
            if("exit".equalsIgnoreCase(path)){
                System.exit(0);
            }
            file = new File(path);
        }
        System.out.println("请输入ffmpeg.exe文件绝对路径");
        String ffmpegPath = sc.nextLine();
        while(!file.exists()){
            System.out.println("ffmpeg.exe路径有误，请重新输入,输入exit退出系统");
            ffmpegPath = sc.nextLine();
            if("exit".equalsIgnoreCase(path)){
                System.exit(0);
            }
        }
        /*File file = new File("G:\\圣思园Java\\北京圣思园XML培训视频");
        String ffmpegPath = "E:\\Software_Compression_Zip\\video_deal\\ffmpeg.exe";*/
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("result.txt"), "utf-8"));
        try{
            doFetch(bw, file, ffmpegPath, 0);
        } finally {
            bw.close();
        }

    }

    private static void doFetch(BufferedWriter bw, File file, String ffmpegPath, int location) throws IOException {
        if(!file.isDirectory()){
            if(file.getName().contains(".") && videoNames.contains(file.getName().substring(file.getName().lastIndexOf(".")))){
                String suply = "";
                for(int i = 0; i < location; i++){
                    suply += "\t";
                }
                suply += "视频：" + file.getName() + "\t";
                System.out.print(suply);

                FFMPEGLocator locator = new FFMPEGLocator() {
                    @Override
                    protected String getFFMPEGExecutablePath() {
                        return ffmpegPath;
                    }
                };
                Encoder encoder = new Encoder(locator);
                try {
                    MultimediaInfo m = encoder.getInfo(file);
                    long ls = m.getDuration();
                    StringBuilder sb = new StringBuilder("此视频时长为:")
                            .append(ls)
                            .append("毫秒，具体时间为：")
                            .append(ls / (60 * 60 * 1000)).append("时")
                            .append((ls % (60 * 60 * 1000)) / 60000).append("分")
                            .append(((ls % (60 * 60 * 1000)) % 60000) / 1000 ).append("秒")
                            .append((((ls % (60 * 60 * 1000)) % 60000) % 1000)).append("毫秒！");
                    String length = sb.toString();
                    suply += length;
                    System.out.println(length);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                bw.write(suply);
                bw.newLine();
            }
        } else {
            String suply = "";
            for(int i = 0; i < location; i++){
                suply += "\t";
            }
            String fileName = file.getName();
            suply += fileName;
            Matcher matcher = pattern.matcher(fileName);
            if(matcher.find()){
                String createdDate = matcher.group();
                int endIndex = matcher.end();
                if(endIndex < fileName.length() && fileName.charAt(endIndex) == '-'){
                    fileName = fileName.replaceFirst("-", "");
                }
                String createdBy = "";
                int lastIndex = -1;
                if(fileName.contains("-")){
                    String[] split = fileName.split("-");
                    if(split[split.length - 1].length() <= 3){
                        createdBy = split[split.length - 1];
                        lastIndex = fileName.lastIndexOf("-");
                    }
                }
                String title = "";
                if(lastIndex != -1){
                    title = fileName.substring(endIndex, lastIndex);
                } else {
                    title = fileName.substring(endIndex);
                }
                suply += "\t课程名：" + title + "\t创建人：" + createdBy + "\t创建时间：" + createdDate;
            }
            System.out.println(suply);
            bw.write(suply);
            bw.newLine();
            File[] files = file.listFiles();
            for (File newFile : files) {
                doFetch(bw, newFile, ffmpegPath, location + 1);
            }
        }
    }
}
