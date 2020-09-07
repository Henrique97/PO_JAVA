#include <string.h>
#include <stdlib.h>
#include <stdio.h>
#include "PenWithInk.h"
#include "Pen.h"
#define MAX_CAPACITY 1000

struct pen_with_ink {
	Pen _pen;
	int	_capacity;
};

PenWithInk newPenWithInk(const char *brand, const char *color, int capacity) {
  PenWithInk pen = (PenWithInk)malloc(sizeof(struct pen_with_ink));

  if (pen != NULL && capacity<=MAX_CAPACITY && capacity>=1) {
    pen-> _pen = newPen(brand, color);
    pen->_capacity = capacity;}

   else if (capacity>MAX_CAPACITY || capacity<=1) { // error in allocating memory
      deletePenWithInk(pen);
      pen = NULL;
    }
   return pen;
  }

void  deletePenWithInk(PenWithInk pen) {
  if (pen) {
	deletePen(pen->_pen);
    free(pen);
  }
}
void writePenWithInk(PenWithInk pen,const char *msg) {
  if (pen->_capacity>=1){
	 writePen(pen->_pen, msg);
	 pen->_capacity-=1;}
}

void fillPenWithInk(PenWithInk pen, int capacity) {
	if (capacity >= 1 && capacity + pen-> _capacity <= MAX_CAPACITY)
		pen-> _capacity += capacity;
}
const char *getBrandPenWithInk(PenWithInk pen) { return getBrandPen(pen->_pen);}

const char *getColorPenWithInk(PenWithInk pen) { return getColorPen(pen->_pen);}

int	getCapacityPenWithInk(PenWithInk pen) { return pen->_capacity; }

int equalsPenWithInk(PenWithInk pen1, PenWithInk pen2) {
  if (pen1 == NULL || pen2 == NULL)
    return 0;
    
  return equalsPen(pen1->_pen, pen2->_pen) && (getCapacityPenWithInk(pen1)==getCapacityPenWithInk(pen2));
}
void printPenWithInk(PenWithInk pen) {
  if(pen!=NULL){
  printPen(pen->_pen);
  printf("Capacity:  %d\n", getCapacityPenWithInk(pen));}
}
