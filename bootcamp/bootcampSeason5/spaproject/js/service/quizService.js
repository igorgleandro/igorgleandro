import homeView from '/js/view/homeView.js';

async function getQuestions() {
  const returnRange = homeView.returnRange();
  const returnCategory = homeView.returnCategory();
  const returnDifficulty = homeView.returnDifficulty();
  console.log(returnRange);
  console.log(returnDifficulty);
  console.log(returnCategory);

  const api = `https://opentdb.com/api.php?amount=${returnRange}&category=${returnCategory}&difficulty=${returnDifficulty}`;

  try {
    const response = await fetch(api);
    const data = await response.json();
    return data;
  } catch (error) {
    console.error(error);
  }
}

export default { getQuestions };

