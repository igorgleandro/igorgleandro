

async function fetchSpells() {

  const api = 'https://hp-api.onrender.com/api/spells';
  const response = await fetch(api);
  const data = await response.json();
  const hpSpells = data;
  
  return hpSpells;
}

const hpSpells = fetchSpells()


async function getHpSpell(index) {
  return await hpSpells[index]
};

async function getHpSpells() {
  return await hpSpells;
}

export default {getHpSpell, getHpSpells };



