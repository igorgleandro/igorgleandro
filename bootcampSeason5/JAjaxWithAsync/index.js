document.addEventListener('DOMContentLoaded', fetchRocket);

async function fetchRocket() {

        const api = 'https://lldev.thespacedevs.com/2.2.0/launch/?mode=list';
        const response = await fetch(api);
        
        const data = await response.json();
        const launches = data.results;
        
    

        createCard(launches);
  
}

function createCard(rname) {
    const rocketContainer = document.getElementById('rocketContainer');

    rname.forEach(launch => {
        // Create the card div itself for each element
        const card = document.createElement("div");
        card.classList.add("card");

        // Create elements for title, status description, last updated, LSP name, location, and image
        const title = document.createElement("h2");
        title.innerText = launch.name;

        const statusDescription = document.createElement("p");
        statusDescription.innerText = `Status: ${launch.status.description}`;

        const lastUpdated = document.createElement("p");
        const updatedAt = new Date(launch.last_updated).toLocaleString();
        lastUpdated.innerText = `Last Updated: ${updatedAt}`;

        const lspName = document.createElement("p");
        lspName.innerText = `LSP Name: ${launch.lsp_name}`;

        const location = document.createElement("p");
        location.innerText = `Location: ${launch.location}`;

        // Create an image element and set its source to the launch's image URL
        const image = document.createElement("img");
        image.src = launch.image;
        image.alt = "Rocket Image"; // Alt text for accessibility

        // Append elements to the card
        card.appendChild(title);
        card.appendChild(image);
        card.appendChild(statusDescription);
        card.appendChild(lastUpdated);
        card.appendChild(lspName);
        card.appendChild(location);
        
        // Append the card to the rocket container
        rocketContainer.appendChild(card);
    });
}

