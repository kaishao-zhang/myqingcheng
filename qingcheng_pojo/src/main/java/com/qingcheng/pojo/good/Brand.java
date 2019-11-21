package com.qingcheng.pojo.good;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author 凯少
 * @create 2019-11-18 19:24
 */
@Table(name = "tb_brand")
public class Brand implements Serializable {
    @Id
    private Integer id;
    private String name;
    private String image;
    private String letter;

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    private Integer seq;

    public Brand(Integer id, String name, String image, String latter, Integer seq) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.letter = latter;
        this.seq = seq;
    }

    public Brand() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    @Override
    public String toString() {
        return "goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", latter='" + letter + '\'' +
                ", seq=" + seq +
                '}';
    }
}
