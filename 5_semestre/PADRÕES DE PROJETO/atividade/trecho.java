public class trecho(){


// double a = order.getAmount();

// double b = 1;

// if (a > 10){
//     b = 0.9;
// }


// double c = product.getPrice() * b;
// double d = a *c;


// =============
double orderAmount = order.getAmount();

double discount = orderAmount > 10 ? 0.9 : 1.0;

double productPrice = product.getPrice();

double discountedPrice = productPrice * discount;

double totalPrice = orderAmount * discountedPrice;

}