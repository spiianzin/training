import { Component, OnInit, Input } from '@angular/core';
import { Row } from '../row'

@Component({
  selector: 'app-row-detail',
  templateUrl: './row-detail.component.html',
  styleUrls: ['./row-detail.component.css']
})
export class RowDetailComponent implements OnInit {
  @Input() row: Row;

  constructor() { }

  ngOnInit() {
  }

}
