'use strict';

/*
* Блок констант
*/
const HTTP_OK = 200;

/*
*Элементы на странице
*/
let mainCoworkersTable = document.getElementById('coworkersTable');
let mainDepartmentsTable = document.getElementById('departmentsTable');
let mainProfessionsTable = document.getElementById('professionsTable');

var allItem = [];

let xhr = new XMLHttpRequest();
xhr.open('GET', '/api/v1/coworkers');
xhr.send();

xhr.onload = () => {
    if (xhr.status === HTTP_OK) {
        drawCoworkersRow(xhr.responseText)
    }
};


function drawCoworkersRow(response) {
    let items = JSON.parse(response);
    allItem = JSON.parse(response);
    items.forEach((item, index) => {
        let tr = document.createElement('tr');

        let itemId = document.createElement('td');
        let name = document.createElement('td');
        let lastname = document.createElement('td');
        let surname = document.createElement('td');
        let note = document.createElement('td');

        let professional = document.createElement('td');
        let department = document.createElement('td');
        let editPanel = document.createElement('td');
        editPanel.innerHTML = '<a href="#" onclick="goToUpdateModel(this.id)" id="element-' + item.id + '"data-toggle="modal" data-target="#exampleModal"><i class="fas fa-edit"></i></a>' + '|' + '<a href="#" id="deleteItem-' + item.id + '"  onclick="deleteItem(this.id, this.name)" name="coworkers"><i class="fas fa-user-times" ></i> </a>';

        itemId.innerText = index + 1;
        name.innerText = item.name;
        lastname.innerText = item.lastname;
        surname.innerText = item.surname;
        note.innerText = item.note;

        tr.appendChild(itemId);
        tr.appendChild(name);
        tr.appendChild(lastname);
        tr.appendChild(surname);
        tr.appendChild(note);
        tr.appendChild(professional);
        tr.appendChild(department);
        tr.appendChild(editPanel);
        mainCoworkersTable.appendChild(tr);
    });
}

function goToUpdateModel(id) {
    let elementId = +id.split('-')[1];
    localStorage.setItem('id', elementId);
    let item = allItem.find(value => {
        if (value.id === elementId) {
            return value;
        }
    });

    let name = document.getElementById('name');
    let lastname = document.getElementById('lastname');
    let surname = document.getElementById('surname');
    let note = document.getElementById('note');

    name.value = item.name;
    lastname.value = item.lastname;
    surname.value = item.surname;
    note.value = item.note;
    //console.log(name + lastname + surname);
}

function updateItem() {
    let updatedUser = {};

    let xhr = new XMLHttpRequest();
    xhr.open('PUT', '/api/v1/coworkers');
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.onload = function () {
        if (xhr.status === 200) {
            let itemInfo = JSON.parse(xhr.responseText);
            let allObj = mainCoworkersTable.children;
        }
    };

    updatedUser.name = document.getElementById('name').value;
    updatedUser.lastname = document.getElementById('lastname').value;
    updatedUser.surname = document.getElementById('surname').value;
    updatedUser.note = document.getElementById('note').value;

    xhr.send(JSON.stringify({
        id: localStorage.getItem('id'),
        name: updatedUser.name.toString(),
        lastname: updatedUser.lastname.toString(),
        surname: updatedUser.lastname.toString(),
        note: updatedUser.note.toString(),
        departmentId: 1,
        professionId: 1
    }));

    let neededObj = document.getElementById('element-' + localStorage.getItem('id')).parentElement.parentElement;
    let values = Object.values(updatedUser);
    var BreakException = {};
    Array.from(neededObj.children).forEach((value, index) => {
        if (index === 0) return;
        if (index >= 5) return;
        value.innerText = values[index - 1];
    });
    localStorage.removeItem('id');

    document.getElementById('closedata').click();
}

function deleteItem(id, name) {
    alert(id);
    let elementId = id.split('-')[1];
alert(elementId);
    let xhr = new XMLHttpRequest();
    xhr.open('DELETE', '/api/v1/' + name + '?id=' + elementId);
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.onload = function () {
        if (xhr.status === 200) {
            document.getElementById(id).parentElement.parentElement.remove();
        }
    };

    xhr.send();
}


function getDepartments() {
    let xhr = new XMLHttpRequest();
    xhr.open('GET', '/api/v1/departments');
    xhr.send();

    xhr.onload = () => {
        if (xhr.status === HTTP_OK) {
            console.log(xhr.responseText);
            drawDepartmentsRow(xhr.responseText)
        }
    };
}


function getProfessions() {
    let xhr = new XMLHttpRequest();
    xhr.open('GET', '/api/v1/professions');
    xhr.send();

    xhr.onload = () => {
        if (xhr.status === HTTP_OK) {
            console.log(xhr.responseText);
            drawProfessionalsRow(xhr.responseText)
        }
    };
}


function drawDepartmentsRow(response) {
    let items = JSON.parse(response);
    console.log(items);
    allItem = JSON.parse(response);
    items.forEach((item, index) => {
        let tr = document.createElement('tr');

        let itemId = document.createElement('td');
        let name = document.createElement('td');
        let note = document.createElement('td');

        let department = document.createElement('td');
        let editPanel = document.createElement('td');
        editPanel.innerHTML = '<a href="#" onclick="goToUpdateModel(this.id)" id="element-' + item.name + '"data-toggle="modal" data-target="#exampleModal"><i class="fas fa-edit"></i></a>' + '|' + '<a href="#" id="deleteItem-' + item.name + '"  onclick="deleteItem(this.id, this.name)  " name="departments"><i class="fas fa-user-times" ></i> </a>';

        itemId.innerText = index + 1;
        name.innerText = item.name;
        note.innerText = item.note;

        tr.appendChild(itemId);
        tr.appendChild(name);
        tr.appendChild(note);
        tr.appendChild(department);
        tr.appendChild(editPanel);
        mainDepartmentsTable.appendChild(tr);
    });
}


function drawProfessionalsRow(response) {
    let items = JSON.parse(response);
    allItem = JSON.parse(response);
    items.forEach((item, index) => {
        let tr = document.createElement('tr');

        let itemId = document.createElement('td');
        let name = document.createElement('td');
        let note = document.createElement('td');

        let editPanel = document.createElement('td');
        editPanel.innerHTML = '<a href="#" onclick="goToUpdateModel(this.id)" id="element-' + item.name + '"data-toggle="modal" data-target="#exampleModal"><i class="fas fa-edit"></i></a>' + '|' + '<a href="#" id="deleteItem-' + item.name + '"  onclick="deleteItem(this.id, this.name)" name="professions"><i class="fas fa-user-times" ></i> </a>';

        itemId.innerText = index + 1;
        name.innerText = item.name;
        note.innerText = item.note;

        tr.appendChild(itemId);
        tr.appendChild(name);
        tr.appendChild(note);
        tr.appendChild(editPanel);
        mainProfessionsTable.appendChild(tr);
    });
}
