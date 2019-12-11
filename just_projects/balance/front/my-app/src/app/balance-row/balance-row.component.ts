import { Component, OnInit } from '@angular/core';
import { ROWS } from '../mock-balance-rows'

@Component({
  selector: 'app-balance-row',
  templateUrl: './balance-row.component.html',
  styleUrls: ['./balance-row.component.css']
})
export class BalanceRowComponent implements OnInit {
  rows = ROWS;

  constructor() { }

  ngOnInit() {
  }

}
