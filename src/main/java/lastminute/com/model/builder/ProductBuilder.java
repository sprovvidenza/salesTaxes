package lastminute.com.model.builder;

import lastminute.com.model.Genre;
import lastminute.com.model.Product;

public class  ProductBuilder {
        private int quantity;
        private Genre genre;
        private Float price;
        private Boolean imported = false;
        private String title;

        public ProductBuilder() {
        }

        public ProductBuilder title(String title){
            this.title = title;
            return this;
        }

        public ProductBuilder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public ProductBuilder genre(Genre genre) {
            this.genre = genre;
            return this;
        }

        public ProductBuilder price(Float price) {
            this.price = price;
            return this;
        }

        public ProductBuilder imported(Boolean imported) {
            this.imported = imported;
            return this;
        }

        public Product build() {
            return new Product(this.quantity, this.genre, this.title, this.price, this.imported);
        }

    @Override
    public String toString() {
        return "ProductBuilder{" +
                "quantity=" + quantity +
                ", genre='" + genre + '\'' +
                ", price=" + price +
                ", imported=" + imported +
                ", title='" + title + '\'' +
                '}';
    }
}