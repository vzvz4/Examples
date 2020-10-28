/*
 * Test
 *
 * Copyright (c) 2005 Eugene Matyushkin (E-mail: skipy@mail.ru)
 *
 * License agreement:
 *
 * 1. This code is published AS IS. Author is not responsible for any damage that can be
 *    caused by any application that uses this code.
 * 2. Author does not give a garantee, that this code is error free.
 * 3. This code can be used in NON-COMMERCIAL applications AS IS without any special
 *    permission from author.
 * 4. This code can be modified without any special permission from author IF AND ONLY IF
 *    this license agreement will remain unchanged.
 * 5. SPECIAL PERMISSION for this code usage in COMMERCIAL application SHOULD be obtained
 *    from author.
 */
package SerializeExternalize.serialization;

import java.util.Random;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;

/**
 * Test
 *
 * This class represents a serialization vs. externalization test.
 *
 * @author Eugene Matyushkin
 * @version 1.0
 */
public class Test {

    public static void main(String[] args) throws Exception{
        if (args.length < 1){
            System.out.println("Object counter is not set!");
            return;
        }
        int counter = 0;
        try{
            counter = Integer.parseInt(args[0]);
        }catch(NumberFormatException ex){
            System.err.println("Exception while parsing object counter param: "+ex.getMessage());
            return;
        }
        ContainerSer cs = new ContainerSer();
        ContainerExt1 ce1 = new ContainerExt1();
        ContainerExt2 ce2 = new ContainerExt2();
        ContainerExt3 ce3 = new ContainerExt3();
        int fieldInt;
        boolean fieldBoolean;
        long fieldLong;
        float fieldFloat;
        double fieldDouble;
        String fieldString;
        Random r = new Random();
        r.setSeed(System.currentTimeMillis());
        System.out.println("Creating "+counter+" objects");
        for(int i=0; i < counter; i++){
            fieldInt = r.nextInt();
            fieldBoolean = r.nextBoolean();
            fieldLong = r.nextLong();
            fieldFloat = r.nextFloat();
            fieldDouble = r.nextDouble();
            fieldString = "" + (fieldLong * fieldFloat / (fieldDouble == 0.0 ? 0.3 : fieldDouble));
            ItemExt ext = new ItemExt(fieldInt, fieldBoolean, fieldLong, fieldFloat, fieldDouble, fieldString);
            ItemSer ser = new ItemSer(fieldInt, fieldBoolean, fieldLong, fieldFloat, fieldDouble, fieldString);
            cs.addItem(ser);
            ce1.addItem(ext);
            ce2.addItem(ext);
            ce3.addItem(ext);
        }
        ObjectOutputStream oosSer = new ObjectOutputStream(new FileOutputStream("./cont.ser"));
        ObjectOutputStream oosExt1 = new ObjectOutputStream(new FileOutputStream("./contExt1.ser"));
        ObjectOutputStream oosExt2 = new ObjectOutputStream(new FileOutputStream("./contExt2.ser"));
        ObjectOutputStream oosExt3 = new ObjectOutputStream(new FileOutputStream("./contExt3.ser"));
        long serStart = System.currentTimeMillis();
        oosSer.writeObject(cs);
        oosSer.flush();
        long serEnd = System.currentTimeMillis();
        long ext1Start = System.currentTimeMillis();
        oosExt1.writeObject(ce1);
        oosExt1.flush();
        long ext1End = System.currentTimeMillis();
        long ext2Start = System.currentTimeMillis();
        oosExt2.writeObject(ce2);
        oosExt2.flush();
        long ext2End = System.currentTimeMillis();
        long ext3Start = System.currentTimeMillis();
        oosExt3.writeObject(ce3);
        oosExt3.flush();
        long ext3End = System.currentTimeMillis();
        oosSer.close();
        oosExt1.close();
        ObjectInputStream oisSer = new ObjectInputStream(new FileInputStream("./cont.ser"));
        ObjectInputStream oisExt1 = new ObjectInputStream(new FileInputStream("./contExt1.ser"));
        ObjectInputStream oisExt2 = new ObjectInputStream(new FileInputStream("./contExt2.ser"));
        ObjectInputStream oisExt3 = new ObjectInputStream(new FileInputStream("./contExt3.ser"));
        long r_serStart = System.currentTimeMillis();
        ContainerSer r_cs = (ContainerSer)oisSer.readObject();
        long r_serEnd = System.currentTimeMillis();
        long r_ext1Start = System.currentTimeMillis();
        ContainerExt1 r_ce1 = (ContainerExt1)oisExt1.readObject();
        long r_ext1End = System.currentTimeMillis();
        long r_ext2Start = System.currentTimeMillis();
        ContainerExt2 r_ce2 = (ContainerExt2)oisExt2.readObject();
        long r_ext2End = System.currentTimeMillis();
        long r_ext3Start = System.currentTimeMillis();
        ContainerExt3 r_ce3 = (ContainerExt3)oisExt3.readObject();
        long r_ext3End = System.currentTimeMillis();
        System.out.println("Serializable: written in "+(serEnd - serStart)+
                           "ms, readed in "+(r_serEnd-r_serStart));
        System.out.println("Externalizable1: written in "+(ext1End - ext1Start)+
                           "ms, readed in "+(r_ext1End-r_ext1Start));
        System.out.println("Externalizable2: written in "+(ext2End - ext2Start)+
                           "ms, readed in "+(r_ext2End-r_ext2Start));
        System.out.println("Externalizable3: written in "+(ext3End - ext3Start)+
                           "ms, readed in "+(r_ext3End-r_ext3Start));
    }

}
