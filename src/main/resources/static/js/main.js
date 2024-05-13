const getProducts = () => {
    return fetch("/api/products")
        .then(response => response.json());
}

const getCurrentOffer = () => {
    return fetch("/api/current-offer")
        .then(response => response.json());
}

createProductHtmlEl = (productData) => {
    const template = `
        <div>
            <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcThtvTcTtNhsHpbjUJA5zozfapMee2a9MsxXRP4MPxNgQ&s" width="200" height="200">
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
        .then(products => products.map(createProductHtmlEl))
        .then(productsHtmls => {
            productsHtmls.forEach(htmlEl => productsList.appendChild(htmlEl))
        });
})