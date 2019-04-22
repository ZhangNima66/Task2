package cn.com.hnisi.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author maxuezhi
 * @company sinobest
 * @date 2019/4/15
 */
public class Book implements Serializable
{
    private String id;
    private String name;
    private BigDecimal price;
    private String author;
    private Date publicationDate;
    private String image;
    private String description;
    private String category_id;
    private int isDel = 0;

    @Override
    public String toString()
    {
        return "Book{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                ", publicationDate=" + publicationDate +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                ", categoryId='" + category_id + '\'' +
                ", isDel=" + isDel +
                ", category=" + category +
                '}';
    }

    public Date getPublicationDate()
    {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate)
    {
        this.publicationDate = publicationDate;
    }

    public int getIsDel()
    {
        return isDel;
    }

    public void setIsDel(int isDel)
    {
        this.isDel = isDel;
    }

    private Category category;

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

    public BigDecimal getPrice()
    {
        return price;
    }

    public void setPrice(BigDecimal price)
    {
        this.price = price;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public String getImage()
    {
        return image;
    }

    public void setImage(String image)
    {
        this.image = image;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getCategory_id()
    {
        return category_id;
    }

    public void setCategory_id(String category_id)
    {
        this.category_id = category_id;
    }

    public Category getCategory()
    {
        return category;
    }

    public void setCategory(Category category)
    {
        this.category = category;
    }
}
