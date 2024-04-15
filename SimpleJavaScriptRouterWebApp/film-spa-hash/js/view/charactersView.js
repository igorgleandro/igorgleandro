function render(hpCharacters) {
  const container = document.querySelector('#container');
  container.innerHTML = '';
  container.style.marginBottom = '20px';
  container.style.display = 'flex-wrap';
  container.style.alignItems = 'center';

  // Create a container for the filters and search input
  const filterContainer = document.createElement('div');
  filterContainer.style.marginBottom = '20px';
  filterContainer.style.display = 'flex';
  filterContainer.style.alignItems = 'center';

  // Create an input element for filtering by name
  const filterInput = document.createElement('input');
  filterInput.type = 'text';
  filterInput.placeholder = 'Search by Name...';
  filterInput.style.marginRight = '20px';

  // Create checkboxes for each option
  const checkboxes = document.createElement('div');
  checkboxes.innerHTML = `
    <label style="color: RGB(207, 171, 90)"><input type="checkbox" name="filter" value="All"> All</label>
    <label style="color: RGB(115, 12, 5)"><input type="checkbox" name="filter" value="Gryffindor"> Gryffindor</label>
    <label style="color: RGB(255, 204, 0)"><input type="checkbox" name="filter" value="Hufflepuff"> Hufflepuff</label>
    <label style="color: RGB(0, 31, 63)"><input type="checkbox" name="filter" value="Ravenclaw"> Ravenclaw</label>
    <label style="color: RGB(34, 77, 53)"><input type="checkbox" name="filter" value="Slytherin"> Slytherin</label>
  `;

  const filterCheckboxes = checkboxes.querySelectorAll('input[type="checkbox"]');

  // Add event listener to the filter input
filterInput.addEventListener('input', function(event) {
  const searchTerm = event.target.value.toLowerCase();
  // Filter characters based on the search term
  hpCharacters.forEach(({ name }) => {
    const itemName = name.toLowerCase();
    const item = document.querySelector(`[data-name="${itemName}"]`);
    if (itemName.includes(searchTerm)) {
      item.style.display = 'flex';
    } else {
      item.style.display = 'none';
    }
  });
});

// Add event listener to each checkbox
filterCheckboxes.forEach(checkbox => {
  checkbox.addEventListener('change', function(event) {
    // Get the value of the selected checkbox
    const selectedFilter = event.target.value;
    // Filter characters based on the selected checkbox
    hpCharacters.forEach(({ name, house, species }) => {
      const item = document.querySelector(`[data-name="${name.toLowerCase()}"]`);
      if (selectedFilter === 'All' || selectedFilter === house || selectedFilter === species) {
        item.style.display = 'flex';
      } else {
        item.style.display = 'none';
      }
    });
  });
});



  // Append the input and checkboxes to the filter container
  filterContainer.appendChild(filterInput);
  filterContainer.appendChild(checkboxes);

  // Append the filter container to the main container

  container.appendChild(filterContainer);

  // Create a list container for the character cards
  const list = document.createElement('div');
  list.style.display = 'flex';
  list.style.flexWrap = 'wrap';
  list.style.justifyContent = 'center'; // Center items horizontally
  list.style.marginTop = '20px';
  list.className = 'text-center';

  hpCharacters.forEach(({ image, name, dateOfBirth, house, species, wizard, ancestry, patronus }) => {
    const item = document.createElement('div');

    item.style.width = '33%';
    item.style.padding = '10px';
    item.style.height = 'auto';
    item.style.alignContent = 'flex-start';
    item.style.display = "flex";
    item.style.flexDirection = "column";
    item.dataset.name = name.toLowerCase();
    item.dataset.house = house; 
  

    const mediaQuery = window.matchMedia("(max-width: 768px)");

    if (mediaQuery.matches) {
      item.style.width = '100%';
      item.style.height = 'auto';
      item.style.alignItems = 'center';
    }

    item.innerHTML = ` 
    <div class="flip-card">
      <div class="flip-card-inner">
        <div class="flip-card-front">
        
        ${ image ?  `<img src="${image}" alt="Avatar" style="border-radius: 5%;
        width: 150px;
        height: 200px;
        margin-top: 15%;
        margin-bottom: 15%;
        overflow: hidden;
        position: relative;">` 
        : 
        `<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/52/Harry_Potter_Platform_Kings_Cross.jpg/2560px-Harry_Potter_Platform_Kings_Cross.jpg" alt="Alternative Avatar" style="border-radius: 5%;
        width: 150px;
        height: 200px;
        margin-top:15%;
        margin-bottom: 15%;
        overflow: hidden;
        position: relative;">`
      }
      
        
        </div>
        
        <div class="flip-card-back">
        <br>
        <h2>${name}</h2> 
        <p style="font-size: small;">Birth: ${dateOfBirth}</p>
        <br>
        <p> 🏠 House: ${house}, 
        <p>👽 Species: ${species}, 
        <p>🧙‍♀️ Wizard: ${wizard}, 
        <p>🧜 Ancestry: ${ancestry}, 
        <p>🪄 Patronus: ${patronus} </p>
        
      </div>
      </div>
    </div>`;

    list.appendChild(item);
  });

  // Append the list container to the main container
  container.appendChild(list);
};

export default { render };
