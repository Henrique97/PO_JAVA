#ifndef __PEN_WITH_INK_H__
#define __PEN_WITH_INK_H__

typedef struct pen_with_ink *PenWithInk;

PenWithInk newPenWithInk(const char *brand, const char *color, int capacity);
void  deletePenWithInk(PenWithInk pen);
void writePenWithInk(PenWithInk pen, const char* msg);
void fillPenWithInk(PenWithInk pen, int capacity);
const char *getBrandPenWithInk(PenWithInk pen);
const char *getColorPenWithInk(PenWithInk pen);
int	getCapacityPenWithInk(PenWithInk pen);
int equalsPenWithInk(PenWithInk pen1, PenWithInk pen2);
void printPenWithInk(PenWithInk pen);

#endif
