enum Product {
    // Let's load five products
    CADBURY_PERK(1,5), LIMCA(2,20), BISLERI_MINERAL_WATER(3,30), KURKURE(4,20), PARLE_G(5,10), EMPTY(0,0);
    // enum constant EMPTY as default
    private int selectionNumber;
    private int price;

    Product(int selectionNumber, int price){
        this.selectionNumber = selectionNumber;
        this.price = price;
    }
    int getSelectionNumber(){
        return selectionNumber;
    }

    int getPrice(){
        return price;
    }

    static Product valueOf(int numberSelection)
    {
        for(Product product: Product.values())
        {
            if(numberSelection == product.getSelectionNumber())
                return product;
        }
        return EMPTY;
    }
}
