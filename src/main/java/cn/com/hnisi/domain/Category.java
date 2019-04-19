package cn.com.hnisi.domain;

import java.io.Serializable;

/**
 * @author maxuezhi
 * @company sinobest
 * @date 2019/4/15
 */
public class Category implements Serializable
{
    private String id;
    private String name;
    private String description;
    private int isDel = 0;

    @Override
    public String toString()
    {
        return "Category{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", isDel=" + isDel +
                '}';
    }

    public int getIsDel()
    {
        return isDel;
    }

    public void setIsDel(int isDel)
    {
        this.isDel = isDel;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
}
