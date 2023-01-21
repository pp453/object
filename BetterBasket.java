package catalogue;

import java.io.Serializable;
import java.util.Collections; 

/**
 * Write a description of class BetterBasket here.
 * 
 * @author  Pahalwattage Don Parindiya Ushana
 * @version 1.0
 */
public class BetterBasket extends Basket implements Serializable
{
  private static final long serialVersionUID = 1L; 
  

  // You need to add code here 
  @Override
  public boolean add(Product product){

    // check if a simillar product has been already added to the basket and increment the quantity  
    for( short i =0; i< this.size(); i++){ 

        if(this.get(i).getProductNum() == product.getProductNum()){  
            product.setQuantity(this.get(i).getQuantity() +product.getQuantity()); 
            this.set(i, product);
            return true;
        }
      }

    // else append the new product at the end of the basket 
    return super.add(product); 
  }
  
  // remove entire product specicied if user implicitly stated or when the product count gets below 1
  public boolean remove(String product_num, boolean entire_product){  
    for(short i =0; i <this.size(); i++){
      Product product =this.get(i);
      if(product.getProductNum() ==product_num){
        if(entire_product || product.getQuantity() <=1) {this.remove(i); return true;} 
        this.get(i).setQuantity(product.getQuantity() -1); 
        return true;
      }
    }

    return false;
  }  

  // get the total number of products in the basket 
  public int count_products(){
    int count =0;
    for(Product product:this) {
      count +=product.getQuantity(); // add the quantity of a product to the count  
    }

    return count;
  } 

  // get total cost for products in the cart
  public double getTotalCost(){
    double cost =0.0;
    for(Product product:this) cost +=product.getPrice() *product.getQuantity();
    return cost;
  }  
}
