const budgetinput = document.querySelector('#budgetAmount');
const expenseTitleInput = document.querySelector('#expenseType');
const expenseValueInput = document.querySelector('#expenseAmount');

const calculateBtn = document.querySelector('#calculate');
const addedExpenseBtn = document.querySelector('#addExpense');

const expenseList = document.querySelector('.expenseCollection');
let budgetvalueDisplay = document.querySelector('#budgetValue');
let balanceValueDisplay = document.querySelector('#balanceValue');

let totalFunds = 0;

let itemId = 0;

loadEventListeners();

function loadEventListeners() {
    calculateBtn.addEventListener('click', createBudget);
    addedExpenseBtn.addEventListener('click', addExpense);
}

function createBudget(event) {

    budgetvalueDisplay.innerText = budgetinput.value;
    balanceValueDisplay.innerText = budgetinput.value;
    totalFunds = budgetinput.value;
    budgetinput.value = '';
    event.preventDefault();
}

function addExpense(event) {
    let expense = {
        id: itemId,
        title: expenseTitleInput.value,
        amount: expenseValueInput.value

    };

    totalFunds -= expense.amount;
    balanceValueDisplay.innerText = totalFunds;

    const expenseLi = document.createElement('li');
    expenseLi.className = 'expenseLi';
    expenseLi.innerHTML =
        `<p> ${expense.title}</p>
         <p> : </p>
        <p class = 'expenseAmount' id=${expense.id}>${expense.amount}</p>
    `;

    const removeBtn = document.createElement('icon');
    removeBtn.className = 'fa fa-trash';
    expenseLi.appendChild(removeBtn);

    removeBtn.addEventListener('click',()=> {
        const expenseAmount = document.getElementById(`${expense.id}`);
        const amountToAdd = parseInt(expenseAmount.innerText);
        totalFunds += amountToAdd;
        balanceValueDisplay.innerText = totalFunds;
        expenseList.removeChild(expenseLi);
    });

    expenseList.appendChild(expenseLi);



    itemId++;
    expenseTitleInput.value = '';
    expenseValueInput.value = '';
    event.preventDefault();

}