async function getQuestions() {
    const api = `https://www.thecocktaildb.com/api/json/v1/1/random.php`;
  
    try {
      const response = await fetch(api);
      const data = await response.json();
      return data;
    } catch (error) {
      console.error(error);
    }
  }
  
  export default { getQuestions };