function render(hpSpells) {
  const container = document.querySelector('#container');
  container.innerHTML = '';
  
  // Search_Bar
  const searchInput = document.createElement('input');
  searchInput.type = 'text';
  searchInput.placeholder = 'Search spells...';
  searchInput.style.marginBottom = '20px';
  container.appendChild(searchInput);

  // Function to filter spells based on search query
  function filterSpells(query) {
    return hpSpells.filter(({ name }) => {
      return name.toLowerCase().includes(query.toLowerCase());
    });
  }

  //Container Speels
  const list = document.createElement('div');
  list.style.display = 'flex';
  list.style.flexWrap = 'wrap';
  list.style.justifyContent = 'center';
  list.style.marginTop = '30px';
  list.className = 'text-center';

  
  //Creat Spells cards

  function renderSpells(spells) {
    list.innerHTML = '';

    spells.forEach(({ name, description }) => {
      const item = document.createElement('div');
      item.style.padding = '10px';
    
      item.innerHTML = `<div class="flip-card">
        <div class="flip-card-inner">
          <div class="flip-card-front"> 
         <img src="https://inspirationlaboratories.com/wp-content/uploads/2018/12/book-of-spells0.jpg" alt="Avatar" style="border-radius: 5%;
          width: 150px;
          height: 130px;
          margin-top: 25%;    
          overflow: hidden;
          position: relative;"> 
        }
        <h3 style="color: white; text-align: center;">${name}</h3> </div>
          <div class="flip-card-back">
          <br>
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
