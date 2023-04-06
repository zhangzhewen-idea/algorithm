package org.zhangzhewen;

import com.github.houbb.heaven.util.io.FileUtil;
import com.github.houbb.pinyin.util.PinyinHelper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Pinyin {
    public static void main(String[] args) {
        // microSD 外接路径
        File dir = new File("/System/Volumes/Data/Volumes/GATEWAYNAND/MD CN 123");
        for(File file : dir.listFiles()){
//            Files.copy(Paths.get(file.getAbsolutePath()),Paths.)
            file.renameTo(new File("/System/Volumes/Data/Volumes/GATEWAYNAND/MD CN 123/"+file.getName().replace(". ",".")));
//            file.renameTo(new File("/System/Volumes/Data/Volumes/GATEWAYNAND/MD CN 123/"+PinyinHelper.toPinyin(file.getName())));
//            System.out.println(file.getName());
//            System.out.println(PinyinHelper.toPinyin(file.getName()));
        }
    }
}
