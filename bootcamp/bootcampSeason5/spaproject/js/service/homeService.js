async function getCategories() {
  const api = `https://opentdb.com/api_category.php`;

  try {
    const response = await fetch(api);
    const data = await response.json();
    return data;
  } catch (error) {
    console.error(error);
  }
}

export default {getCategories};