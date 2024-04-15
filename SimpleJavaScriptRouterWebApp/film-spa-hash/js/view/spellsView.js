function render(hpSpells) {
  const container = document.querySelector('#container');
  container.innerHTML = '';
  container.style.marginBottom = '20px';
  container.style.display = 'flex-wrap';
  container.style.alignItems = 'center';
  
  // Create search input element
  const searchInput = document.createElement('input');
  searchInput.type = 'text';
  searchInput.placeholder = 'Search spells...';
  searchInput.style.marginBottom = '20px';

  // Append search input to the container
  container.appendChild(searchInput);

  const list = document.createElement('div');
  list.style.display = 'flex';
  list.style.flexWrap = 'wrap';
  list.style.marginTop = '20px';
  list.className = 'text-center';

  // Function to filter spells based on search query
  function filterSpells(query) {
    return hpSpells.filter(({ name }) => {
      return name.toLowerCase().includes(query.toLowerCase());
    });
  }

  // Function to render the filtered spells
  function renderSpells(spells) {
    list.innerHTML = ''; // Clear previous spells

    spells.forEach(({ name, description }) => {
      const item = document.createElement('div');
      item.style.width = '33%';
      item.style.padding = '10px';
      item.style.height = 'auto';
      item.style.alignContent = 'flex-start';
      item.style.display = 'flex';
      item.style.flexDirection = 'column';

      const mediaQuery = window.matchMedia('(max-width: 768px)');

      if (mediaQuery.matches) {
        item.style.width = '100%';
        item.style.height = 'auto';
        item.style.alignItems = 'center';
      }

      item.innerHTML = `<div class="flip-card">
        <div class="flip-card-inner">
          <div class="flip-card-front"> 
         <img src="https://inspirationlaboratories.com/wp-content/uploads/2018/12/book-of-spells0.jpg" alt="Avatar" style="border-radius: 5%;
          width: 150px;
          height: 130px;
          margin-top: 25%;
          margin-bottom: 1%;
          overflow: hidden;
          position: relative;"> 
        }
        <h3 style="color: white; text-align: center;">${name}</h3> </div>
          <div class="flip-card-back">
            <h1>${name}</h1> 
            <p style="font-size: small;">Description: ${description}</p>
          </div>
        </div>
      </div>`;

      list.appendChild(item);
    });
  }


  renderSpells(hpSpells);

  // Add event listener for input change to update the search results
  searchInput.addEventListener('input', function() {
    const query = searchInput.value.trim();
    const filteredSpells = filterSpells(query);
    renderSpells(filteredSpells);
  });

  // Append the list of spells to the container
  container.appendChild(list);
}

export default { render };
