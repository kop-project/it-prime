'use strict';

/*
* Блок констант
*/
const HTTP_OK = 200;

/*
*Элементы на странице
*/

let mainCoworkersTable = document.getElementById('coworkersTable');

let xhr = new XMLHttpRequest();
xhr.open('GET', '/api/v1/coworkers');
xhr.send();

xhr.onload = () => {
    if (xhr.status === HTTP_OK) {
        drawRow(xhr.responseText)
    }
};


function drawRow(response) {
    let items = JSON.parse(response);

    items.forEach((item, index) => {
        let tr = document.createElement('tr');

        let itemId = document.createElement('td');
        let name = document.createElement('td');
        let lastname = document.createElement('td');
        let surname = document.createElement('td');

        let professional = document.createElement('td');
        let department = document.createElement('td');
        let editPanel = document.createElement('td');
        editPanel.innerHTML = '<a href="#"><i class="fas fa-edit"></i></a>' + '|' + '<a href="#"><i class="fas fa-user-times"></i></a>';

        itemId.innerText = index + 1;
        name.innerText = item.name;
        lastname.innerText = item.lastname;
        surname.innerText = item.surname;

        tr.appendChild(itemId);
        tr.appendChild(name);
        tr.appendChild(lastname);
        tr.appendChild(surname);
        tr.appendChild(professional);
        tr.appendChild(department);
        tr.appendChild(editPanel);
        mainCoworkersTable.appendChild(tr);
    });
}

