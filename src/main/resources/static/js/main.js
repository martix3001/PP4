
//API CONTEXT
const getProducts = () => {
    return fetch("/api/products")
        .then(response => response.json());
}

const getCurrentOffer = () => {
    return fetch("/api/current-offer")
        .then(response => response.json());
}
const addProductToCart = (product) => {
    return fetch(`api/add-to-cart/${product}`, {
        method: "POST",
    });
}
createProductHtmlEl = (productData) => {
    const template = `
        <div>
            
            <img src="https://cdn.pixabay.com/photo/2016/06/14/04/51/bag-1455765_1280.jpg" alt="zdjęcie produktu" width="200" height="200">
            <h4>${productData.name}</h4>
            <span>${productData.description}</span>
            <span>${productData.price}</span>
            <button data-id ="${productData.id}"> Add to cart</button>
        </div>
    `;
    const newEl = document.createElement("li");
    newEl.innerHTML = template.trim();
    return newEl;
}

document.addEventListener("DOMContentLoaded", () => {
    console.log("it works");
    const productsList = document.querySelector("#productsList");
    getProducts()
        .then(productAsJson => productAsJson.map(createProductHtmlEl))
         .then(productsHtmls => productsHtmls.map(initializeCartHandler))
        .then(productsHtmls => {
            productsHtmls.forEach(htmlEl => productsList.appendChild(htmlEl))
        });
})
const acceptOffer = (acceptOfferRequest) => {
    return fetch("/api/accept-offer", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(acceptOfferRequest),
    }).then(response => response.json());
}
const initializeCartHandler = (productHtmlEl) => {
    const addToCartBtn = productHtmlEl.querySelector("button[data-id]")
    addToCartBtn.addEventListener("click", (event) => {
        const productId = event.target.getAttribute("data-id");
        addProductToCart(productId)
            .then(refreshCurrentOffer());
    });
    return productHtmlEl;
}
const refreshCurrentOffer = () => {
    const totalEl = document.querySelector('#offer__items-total');
    const itemCountEl = document.querySelector('#offer__items-count');

    getCurrentOffer()
        .then(offer => {
            totalEl.textContent = `${offer.total} PLN`;
            itemCountEl.textContent = `${offer.itemsCount} Items`;
        })
}
const checkoutFormEl = document.querySelector('#checkout');
checkoutFormEl.addEventListener("submit", (event) => {
    event.preventDefault();

    const acceptOfferRequest = {
        firstName: checkoutFormEl.querySelector('input[name="first_name"]').value,
        lastName: checkoutFormEl.querySelector('input[name="last_name"]').value,
        email: checkoutFormEl.querySelector('input[name="email"]').value,
    }

    acceptOffer(acceptOfferRequest)
        .then(resDetails => window.location.href = resDetails.paymentUrl);
});

