package fi.haagahelia.course.Camerastore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.haagahelia.course.Camerastore.domain.ConditionRepository;
import fi.haagahelia.course.Camerastore.domain.Product;
import fi.haagahelia.course.Camerastore.domain.ProductRepository;
import fi.haagahelia.course.Camerastore.domain.StatusRepository;

@CrossOrigin
@Controller
public class ProductController {	 
	@Autowired
	private ProductRepository ProductRepo;	
	@Autowired
	private ConditionRepository ConditionRepo;
	@Autowired
	private StatusRepository StatusRepo;
	
	/*
	 * This endpoint lists all the products on the homepage
	 * Admins can also delete, edit or add new products from this page
	 * User can access to product pages by clicking the name of the product
	 */
	@RequestMapping(value={"/", "/home"})
	public String cameraStore(Model model) {
		model.addAttribute("products", ProductRepo.findAll());
		return "productlist";
	}
	/*
	 * Endpoint to delete a specific product. The productId comes in a
	 * PathVariable. It returns back to homepage 
	 * It is only visible to admins
	 */
	@GetMapping("/delete/{id}")
	public String deleteProduct(@PathVariable("id") Long productId, Model model) {
		ProductRepo.deleteById(productId);
		return "redirect:../home";
	}
	/*
	 * Endpoint to edit products. This method gets the id through PathVariable.
	 * It is only visible to admins
	 */

	@GetMapping("/edit/{id}")
	public String editProduct(@PathVariable("id") Long productId, Model model) {
		model.addAttribute("product", ProductRepo.findById(productId));
		model.addAttribute("conditions", ConditionRepo.findAll());
		model.addAttribute("statuses", StatusRepo.findAll());
		return "editproduct";
	}
	/*
	 * With this endpoint user can add new products to the productlist. It
	 * is only visible to admins
	 */
	@RequestMapping(value = "/add")
	public String addProduct(Model model) {
		model.addAttribute("product", new Product());
		model.addAttribute("conditions", ConditionRepo.findAll());
		model.addAttribute("statuses", StatusRepo.findAll());
		return "addproduct";
		}
	/*
	 * This endpoint saves the changes made to existing products or saves
	 * the new ones and adds them into the ProductRepository.
	 * Only visible to admins.
	 */
	@PostMapping("/save")
	public String save(Product product) {
		ProductRepo.save(product);
		return "redirect:home";
		}
	// gets all the products
	@GetMapping("/products")
	public @ResponseBody List<Product> getAllProducts() {
		return(List<Product>) ProductRepo.findAll();
		}
	// get product by id
	@GetMapping("/products/{id}")
	public @ResponseBody Optional<Product> getProductById(@PathVariable(name = "id") Long productId) {
		return ProductRepo.findById(productId);
	}
}
